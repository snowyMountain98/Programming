import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[] num, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		long N, M, K, h;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		num = new long[(int) (N + 1)];
		for (int i = 1; i <= N; i++)
			num[i] = Long.parseLong(br.readLine());

		/************************************************************
		 *              logN
		 * h = log₂N = ──────
		 *              log2
		 * 
		 * 배열의 길이: 1 + 2 + 2² + ··· + 2^h
		 * 
		 * 등비수열의 합 (a:첫번쨰 항, r:공비, n:항의 갯수)
		 *      a(1 - rⁿ)     1(1 - 2^(h+1))
		 * S = ─────────── → ──────────────── = 2^(h+1) - 1
		 *        1 - r           1 - 2
		 ************************************************************/

		/* 트리 높이 계산 */
		h = (int) Math.ceil(Math.log(N) / Math.log(2));
		tree = new long[(int) Math.pow(2, h + 1)];    // 트리의 총 노드 수 = 2^(h+1) - 1

		/* 세그먼트 트리 초기화 */
		init(1, 1, N);

		/* M + K개의 연산 처리 */
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			switch (a) {
			/* a = 1 → b번째 수를 c로 변경 */
			case 1:
				/* 현재 값과의 차이를 구해서 트리 업데이트 */
				update(1, 1, N, b, c - num[b]);
				num[b] = c;
				break;
			/* a = 2 → b번째 수부터 c번째 수까지의 합 */
			case 2:
				bw.write(sum(1, 1, N, b, c) + "\n");
				break;
			}
		}

		bw.flush();
	}

	/**
	 * 세그먼트 트리 초기화 함수 node: 현재 노드 번호, start~end: 현재 노드가 담당하는 구간
	 */
	public static void init(int node, long start, long end) {
		/* 리프 노드인 경우 실제 배열의 값 저장 */
		if (start == end)
			tree[node] = num[(int) start];
		else {
			/* 자식 노드들을 재귀적으로 초기화 */
			init(node * 2, start, (start + end) / 2); // 왼쪽 자식
			init(node * 2 + 1, (start + end) / 2 + 1, end); // 왼쪽 자식
			/* 부모 노드는 두 자식의 합 */
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

	/**
	 * 구간 합을 구하는 함수 node: 현재 노드, start~end: 현재 노드의 범위, left~right: 구하려는 범위
	 */
	public static long sum(int node, long start, long end, int left, long right) {
		/* 범위 밖인 경우 결과에 영향 없음 */
		if (end < left || right < start)
			return 0;

		/* 구하려는 범위에 완전히 포함된 경우 현재 노드 값 사용 */
		if (left <= start && end <= right)
			return tree[node];

		/* 일부만 포함된 경우 자식 노드로 내려가서 합산 */
		return sum(node * 2, start, (start + end) / 2, left, right)
				+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	/**
	 * 특정 인덱스 값 변경 시 트리 업데이트 함수 idx: 변경할 인덱스, diff: 변경된 값 - 기존 값의 차이
	 */
	public static void update(int node, long start, long end, int idx, long diff) {
		/* idx가 현재 노드의 범위를 벗어난 경우 무시 */
		if (idx < start || end < idx)
			return;

		/* 현재 노드의 구간 합에 diff를 더함 */
		tree[node] += diff;

		/* 리프 노드가 아닌 경우 자식 노드로 재귀 호출 */
		if (start != end) {
			update(node * 2, start, (start + end) / 2, idx, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		}
	}
}
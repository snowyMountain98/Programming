import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] prnt;

	static class Cmptr implements Comparable<Cmptr> {
		int a, b, c;

		public Cmptr(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		/* 비용을 기준으로 정렬 */
		@Override
		public int compareTo(Cmptr o) {
			return Integer.compare(this.c, o.c);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, cost = 0;
		PriorityQueue<Cmptr> pQ = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			pQ.offer(new Cmptr(a, b, c));
		}

		/* 부모 배열 초기화 (자기 자신을 부모로 설정) */
		prnt = new int[N + 1];
		for (int i = 1; i <= N; i++)
			prnt[i] = i;

		/* 크루스칼 알고리즘: 비용이 낮은 간선부터 선택하며 MST 구성 */
		while (!pQ.isEmpty()) {
			Cmptr C = pQ.poll();

			/* 같은 집합에 속해 있으면 사이클이 생기므로 스킵 */
			if (find(C.a) == find(C.b))
				continue;

			cost += C.c;		// 간선 비용 추가
			union(C.a, C.b);	// 두 집합을 병합
		}

		bw.write(cost + "\n");
		bw.flush();
	}

	/**
	 * find 함수: 경로 압축을 이용한 부모 찾기
	 */
	public static int find(int a) {
		if (prnt[a] == a)
			return a;
		else
			return prnt[a] = find(prnt[a]);	// 경로 압축
	}

	/**
	 * union 함수: 두 집합을 합침
	 */
	public static void union(int a, int b) {
		int x, y;

		x = prnt[a];
		y = prnt[b];

		/* 작은 값 쪽을 부모로 설정 */
		if (x < y)
			prnt[y] = x;
		else
			prnt[x] = y;
	}

}
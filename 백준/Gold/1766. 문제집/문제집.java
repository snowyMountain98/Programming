import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		ArrayList<ArrayList<Integer>> order = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int N, M;
		int[] degree;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++)
			order.add(new ArrayList<>());

		degree = new int[N + 1];

		/* 문제 간의 선후 관계 입력 */
		while (M > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			/* A를 풀어야 B를 풀 수 있음 */
			order.get(A).add(B);
			degree[B]++;	// B의 진입 차수 증가

			M--;
		}

		/* 진입 차수가 0인 문제들을 우선순위 큐에 삽입 */
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0)
				pQ.offer(i);
		}

		/* 위상 정렬 */
		while (!pQ.isEmpty()) {
			/* 현재 풀 수 있는 문제 중 번호가 가장 작은 문제 선택 */
			int now = pQ.poll();

			/* 문제 풀이 순서에 추가 */
			sb.append(now + " ");

			/* now 문제를 풀었으므로 now 이후에 풀 수 있는 문제들 처리 */
			for (int next : order.get(now)) {
				degree[next]--;	// 선행 문제 하나 해결됨

				/* 더 이상 선행 문제가 없으면 큐에 추가 */
				if (degree[next] == 0)
					pQ.offer(next);
			}
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
	}

}
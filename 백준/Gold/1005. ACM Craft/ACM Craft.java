import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<ArrayList<Integer>> order;
		int T, N, K, W;
		int[] D, degree, time;
		Queue<Integer> Q = new LinkedList<>();

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			D = new int[N + 1];
			degree = new int[N + 1];
			time = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				D[i] = Integer.parseInt(st.nextToken());

			order = new ArrayList<>();
			for (int i = 0; i <= N; i++)
				order.add(new ArrayList<>());

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				order.get(X).add(Y);	// X → Y로 향하는 간선 추가
				degree[Y]++;			// Y의 진입 차수 증가
			}

			W = Integer.parseInt(br.readLine());

			/* 진입 차수가 0인 건물(선행 건물이 없는 건물)을 큐에 추가 */
			for (int i = 1; i <= N; i++) {
				if (degree[i] == 0) {
					Q.add(i);
					time[i] = D[i];	// 선행 건물이 없으므로 짓는 시간 = Di
				}
			}

			/* 위상 정렬 + DP 수행 */
			while (!Q.isEmpty()) {
				int now = Q.poll();

				/* 현재 건물에서 시작되는 다음 건물들 탐색 */
				for (int next : order.get(now)) {
					/* next 건물까지 걸리는 시간을 최대값으로 갱신 */
					time[next] = Math.max(time[next], time[now] + D[next]);
					/* next 건물의 진입 차수 감소 */
					degree[next]--;

					/* 모든 선행 건물이 끝났으면 큐에 추가 */
					if (degree[next] == 0)
						Q.add(next);
				}
			}

			bw.write(time[W] + "\n");

			T--;
		}

		bw.flush();
	}

}
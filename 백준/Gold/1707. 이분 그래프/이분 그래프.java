import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K, V, E;
		int[] color;
		List<List<Integer>> graph;
		Queue<Integer> Q;
		String answer;

		K = Integer.parseInt(br.readLine());

		while (K > 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			color = new int[V + 1];

			graph = new ArrayList<>();
			for (int i = 0; i <= V; i++)
				graph.add(new ArrayList<>());

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int v = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph.get(v).add(e);
				graph.get(e).add(v);
			}

			/**************************************************
			 * graph:
			 * 1: [3]
			 * 2: [3]
			 * 3: [1, 2]
			 **************************************************/

			answer = "YES";
			Q = new LinkedList<>();

			AA:
			for (int i = 1; i <= V; i++) {
				/* 이미 방문한 정점은 건너뜀 */
				if (color[i] != 0)
					continue;

				/* 시작 정점 색칠 및 큐에 추가 */
				color[i] = 1;
				Q.add(i);

				/* BFS */
				while (!Q.isEmpty()) {
					int now = Q.poll();

					for (int nxt : graph.get(now)) {
						/* 인접 정점이 같은 색이면 이분 그래프가 아님 */
						if (color[now] == color[nxt]) {
							answer = "NO";
							break AA;
						}

						/* 인접 정점이 아직 색칠되지 않았다면 반대 색으로 색칠 */
						if (color[nxt] == 0) {
							color[nxt] = color[now] * (-1);
							Q.add(nxt);
						}
					}
				}
			}

			/**************************************************
			 * color:
			 * [1, 1, -1] 
			 **************************************************/

			bw.write(answer + "\n");
			K--;
		}

		bw.flush();
	}

}
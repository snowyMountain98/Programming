import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Road implements Comparable<Road> {
		int town, T;

		public Road(int town, int T) {
			this.town = town;
			this.T = T;
		}

		/* 우선순위 큐에서 T(시간) 기준으로 오름차순 정렬 */
		@Override
		public int compareTo(Road o) {
			return Integer.compare(this.T, o.T);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<ArrayList<Road>> route1, route2;
		int N, M, X, max = 0;
		int[] go, cmBck;
		PriorityQueue<Road> pQ = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		/* route1: X에서 각 마을로 가는 경로, route2: 각 마을에서 X로 돌아오는 경로 (역방향 그래프) */
		route1 = new ArrayList<>();
		route2 = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			route1.add(new ArrayList<>());
			route2.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			route1.get(A).add(new Road(B, T));	// A → B (정방향)
			route2.get(B).add(new Road(A, T));	// B → A (역방향)
		}
		
		/**************************************************
		 * route1
		 * 1: [2, 4], [3, 2], [4, 7]
		 * 2: [1, 1], [3, 5]
		 * 3: [1, 2], [4, 4]
		 * 4: [2, 3]
		 * 
		 * route2
		 * 1: [2, 1], [3, 2]
		 * 2: [1, 4], [4, 3]
		 * 3: [1, 2], [2, 5]
		 * 4: [1, 7], [3, 4]
		 **************************************************/

		go = new int[N + 1];
		cmBck = new int[N + 1];

		Arrays.fill(go, Integer.MAX_VALUE);
		Arrays.fill(cmBck, Integer.MAX_VALUE);

		go[X] = 0;
		cmBck[X] = 0;

		pQ.add(new Road(X, 0));

		/* X에서 다른 마을로 가는 최단 경로 (정방향 그래프 route1 사용) */
		while (!pQ.isEmpty()) {
			Road now = pQ.poll();

			if (go[now.town] < now.T)
				continue;

			for (Road next : route1.get(now.town)) {
				int newT = now.T + next.T;

				if (go[next.town] > newT) {
					go[next.town] = newT;
					pQ.add(new Road(next.town, newT));
				}
			}
		}

		/**************************************************
		 * go : [1, 0, 3, 7]
		 **************************************************/

		pQ.add(new Road(X, 0));

		/* X로 돌아오는 최단 경로 (역방향 그래프 route2 사용) */
		while (!pQ.isEmpty()) {
			Road now = pQ.poll();

			if (cmBck[now.town] < now.T)
				continue;

			for (Road next : route2.get(now.town)) {
				int newT = now.T + next.T;

				if (cmBck[next.town] > newT) {
					cmBck[next.town] = newT;
					pQ.add(new Road(next.town, newT));
				}
			}
		}

		/**************************************************
		 * cmBck : [4, 0, 6, 3]
		 **************************************************/

		/* 각 마을에서 파티를 갔다가 돌아오는 시간 중 최댓값 구하기 */
		for (int i = 1; i <= N; i++)
			max = Math.max(max, go[i] + cmBck[i]);

		bw.write(max + "\n");
		bw.flush();
	}

}
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

	static class Bus implements Comparable<Bus> {
		int city, cost;

		public Bus(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}

		/* 비용을 기준으로 오름차순 정렬 */
		@Override
		public int compareTo(Bus o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<ArrayList<Bus>> route = new ArrayList<>();
		int N, M, start, end;
		int[] minCost;
		PriorityQueue<Bus> pQ = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		minCost = new int[N + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);

		for (int i = 0; i <= N; i++)
			route.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			route.get(Integer.parseInt(st.nextToken()))
					.add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		/**************************************************
		 * 1 : [2, 2], [3, 3], [4, 1], [5, 10]
		 * 2 : [4, 2]
		 * 3 : [4, 1], [5, 1]
		 * 4 : [5, 3]
		 * 5 :
		 **************************************************/

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		pQ.add(new Bus(start, 0));
		minCost[start] = 0;

		/* 다익스트라 알고리즘 */
		while (!pQ.isEmpty()) {
			Bus now = pQ.poll();

			/* 이미 처리된 노드라면 스킵 */
			if (minCost[now.city] < now.cost)
				continue;

			/* 현재 도시에서 연결된 모든 노선을 탐색 */
			for (Bus next : route.get(now.city)) {
				int newCost = minCost[now.city] + next.cost; // 현재 도시를 경유한 새로운 비용 계산

				/* 기존 비용보다 새로운 비용이 더 작다면 갱신 */
				if (minCost[next.city] > newCost) {
					minCost[next.city] = newCost;
					pQ.add(new Bus(next.city, newCost));
				}
			}
		}

		bw.write(minCost[end] + "\n");
		bw.flush();
	}

}
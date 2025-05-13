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
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int N, INF = 2000000;

	static class Node implements Comparable<Node> {
		int v, w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int E, v1, v2;
		int[] dstnc, dstnc1, dstnc2;
		long path1, path2, route;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<Node>());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		/* 다익스트라 알고리즘 수행 */
		dstnc = dijkstra(1);	// 1번 정점에서 시작하는 최단 거리
		dstnc1 = dijkstra(v1);	// v1번 정점		〃
		dstnc2 = dijkstra(v2);	// v2번 정점		〃

		/* (1 → v1 → v2 → N) 경로 계산 */
		path1 = dstnc[v1] + dstnc1[v2] + dstnc2[N];
		/* (1 → v2 → v1 → N) 경로 계산 */
		path2 = dstnc[v2] + dstnc2[v1] + dstnc1[N];

		/* 두 경로 중 최소값 선택 */
		route = Math.min(path1, path2);

		/* 도달할 수 없는 경우 -1 반환 */
		route = route >= INF ? -1 : route;

		bw.write(route + "\n");
		bw.flush();
	}

	/* 다익스트라 알고리즘 */
	public static int[] dijkstra(int s) {
		int[] d = new int[N + 1];
		PriorityQueue<Node> pQ = new PriorityQueue<>();

		Arrays.fill(d, INF);

		pQ.add(new Node(s, 0));
		d[s] = 0;

		while (!pQ.isEmpty()) {
			Node now = pQ.poll();

			if (d[now.v] < now.w)
				continue;

			for (Node next : graph.get(now.v)) {
				int newW = now.w + next.w;

				if (d[next.v] > newW) {
					d[next.v] = newW;
					pQ.add(new Node(next.v, newW));
				}
			}
		}

		return d;
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, V, x, y;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(graph[i]);

		/******************************
		 * graph:
		 * 1 - [2, 3, 4]
		 * 2 - [1, 4]
		 * 3 - [1, 4]
		 * 4 - [1, 2, 3]
		 ******************************/

		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");

		visited = new boolean[N + 1];
		bfs(V);

		bw.write(sb + "\n");
		bw.flush();
	}

	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");

		for (int i : graph[v]) {
			if (!visited[i])
				dfs(i);
		}
	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");

			for (int i : graph[current]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}

			}
		}
	}
	
}
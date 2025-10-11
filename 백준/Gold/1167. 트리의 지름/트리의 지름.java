import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]>[] tree;
	static boolean[] vstd;
	static int V, dmtr, endPoint;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());

		tree = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			while (true) {
				int X = Integer.parseInt(st.nextToken());

				if (X == -1)
					break;

				int Y = Integer.parseInt(st.nextToken());

				tree[N].add(new int[] { X, Y });
			}
		}

		/* 임의의 노드(1번)에서 DFS 수행하여 가장 먼 정점 찾기 */
		vstd = new boolean[V + 1];
		vstd[1] = true;
		dfs(1, 0);

		/* 위에서 찾은 가장 먼 정점(endPoint)에서 다시 DFS 수행하여 트리의 지름 구하기 */
		vstd = new boolean[V + 1];
		vstd[endPoint] = true;
		dfs(endPoint, 0);

		bw.write(dmtr + "\n");
		bw.flush();

	}

	/**
	 * DFS 함수: 현재 노드(now)에서 누적 거리(sum)를 기반으로 탐색
	 */
	public static void dfs(int now, int sum) {
		/* 현재 누적 거리가 기존 최대 거리보다 크면 갱신 */
		if (dmtr < sum) {
			dmtr = sum;
			endPoint = now;
		}

		/* 인접 노드 탐색 */
		for (int[] nxt : tree[now]) {
			if (vstd[nxt[0]])
				continue;

			vstd[nxt[0]] = true;
			dfs(nxt[0], sum + nxt[1]);
			vstd[nxt[0]] = false;
		}
	}

}
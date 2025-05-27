import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] tree;
	static boolean[] vstd;
	static int dmtr, endPoint;

	static class Node {
		int vrtx, wght;

		Node(int vrtx, int wght) {
			this.vrtx = vrtx;
			this.wght = wght;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n;

		n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			tree[a].add(new Node(b, c));
			tree[b].add(new Node(a, c));
		}

		/* 첫 번째 DFS: 루트 노드에서 가장 먼 노드 찾기 */
		vstd = new boolean[n + 1];
		vstd[1] = true;
		dfs(1, 0);

		/* 두 번째 DFS: 가장 먼 노드에서 DFS → 지름 계산 */
		vstd = new boolean[n + 1];
		vstd[endPoint] = true;
		dfs(endPoint, 0);

		bw.write(dmtr + "\n");
		bw.flush();
	}

	/**
	 * DFS : 현재 노드에서 누적 거리를 기준으로 탐색
	 * 
	 * @param now : 현재 노드
	 * @param sum : 누적 거리
	 */
	public static void dfs(int now, int sum) {
		/* 현재까지의 거리가 지름보다 크면 갱신 */
		if (dmtr < sum) {
			dmtr = sum;
			endPoint = now;
		}

		/* 연결된 노드를 순회하며 DFS 재귀 호출 */
		for (Node n : tree[now]) {
			if (vstd[n.vrtx])
				continue;

			vstd[n.vrtx] = true;
			dfs(n.vrtx, sum + n.wght);
			vstd[n.vrtx] = false;
		}

	}

}

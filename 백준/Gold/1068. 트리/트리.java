import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int N, root, rmvl, leaf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N];

		for (int i = 0; i < N; i++)
			tree[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == -1)
				root = i;			// 루트 노드 저장
			else
				tree[num].add(i);	// 부모-자식 관계 추가
		}

		rmvl = Integer.parseInt(br.readLine());	// 삭제할 노드 번호

		/* 루트 노드가 삭제될 경우 트리 전체가 사라지므로 리프 노드 수는 0 */
		if (root == rmvl) {
			bw.write("0\n");
			bw.flush();
			System.exit(0);
		}

		/* 루트에서 DFS 탐색 시작 */
		dfs(root);

		bw.write(leaf + "\n");
		bw.flush();
	}

	/**
	 * DFS를 이용한 리프 노드 탐색
	 */
	public static void dfs(int now) {
		/* 현재 노드의 자식 중 삭제할 노드가 있다면 제거 */
		if (tree[now].contains(rmvl))
			tree[now].remove(Integer.valueOf(rmvl));

		/* 삭제하고 나서 자식이 하나도 없다면 리프 노드로 간주 */
		if (tree[now].size() == 0) {
			leaf++;
			return;
		}

		/* 자식 노드들에 대해 재귀적으로 탐색 */
		for (int child : tree[now])
			dfs(child);
	}
}
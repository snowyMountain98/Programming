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
		int N;
		int[] prnt;
		boolean[] vstd;
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		Queue<Integer> Q = new LinkedList<>();

		N = Integer.parseInt(br.readLine());

		prnt = new int[N + 1];
		vstd = new boolean[N + 1];

		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<>());

		/* 트리 간선 정보 입력 */
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			/* 양방향 간선 추가 */
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		/**************************************************
		 * <tree>
		 * 1: [6, 4]
		 * 2: [4]
		 * 3: [6, 5]
		 * 4: [1, 2, 7]
		 * 5: [3]
		 * 6: [1, 3]
		 * 7: [4]
		 **************************************************/

		/* BFS 시작: 루트 노드(1번 노드)부터 탐색 */
		Q.add(1);
		vstd[1] = true;

		/* BFS 탐색 */
		while (!Q.isEmpty()) {
			int crnt = Q.poll();

			/* 현재 노드와 연결된 노드 리스트 */
			ArrayList<Integer> cnctd = tree.get(crnt);

			for (int i = 0; i < cnctd.size(); i++) {
				/* 이미 방문한 노드는 무시 */
				if (vstd[cnctd.get(i)])
					continue;

				/* 현재 노드를 부모로 설정 */
				prnt[cnctd.get(i)] = crnt;

				/* 연결된 노드를 큐에 추가하고 방문 처리 */
				Q.add(cnctd.get(i));
				vstd[cnctd.get(i)] = true;
			}
		}

		for (int i = 2; i <= N; i++)
			bw.write(prnt[i] + "\n");
		bw.flush();
	}

}
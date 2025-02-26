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
		ArrayList<ArrayList<Integer>> fmly = new ArrayList<>();
		boolean[] vstd;
		int n, m, A, B, x, y;
		Queue<int[]> Q = new LinkedList<>();

		n = Integer.parseInt(br.readLine());
		vstd = new boolean[n + 1];

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		for (int i = 0; i <= n; i++)
			fmly.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			/* 무방향 그래프로 저장 */
			fmly.get(x).add(y);
			fmly.get(y).add(x);
		}

		/**************************************************
		 * 1: [2, 3]
		 * 2: [1, 7, 8, 9]
		 * 3: [1]
		 * 4: [5, 6]
		 * 5: [4]
		 * 6: [4]
		 * 7: [2]
		 * 8: [2]
		 * 9: [2]
		 **************************************************/

		vstd[A] = true;
		Q.offer(new int[] { A, 0 });

		/* BFS 탐색 */
		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			/* 현재 노드가 B와 같다면 촌수 출력 후 종료 */
			if (now[0] == B) {
				bw.write(now[1] + "\n");
				bw.flush();
				System.exit(0);
			}

			/* 현재 노드와 연결된 모든 노드를 탐색 */
			for (int next : fmly.get(now[0])) {
				if (!vstd[next]) {
					vstd[next] = true;
					Q.add(new int[] { next, now[1] + 1 });
				}
			}
		}

		bw.write("-1");
		bw.flush();
	}

}
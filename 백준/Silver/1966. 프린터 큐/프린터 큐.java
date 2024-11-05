import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, N, M, order;
		Queue<int[]> Q;
		int[] crnt;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			Q = new LinkedList<>();
			order = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				Q.add(new int[] { i, Integer.parseInt(st.nextToken()) });

			while (!Q.isEmpty()) {
				crnt = Q.poll();

				/* 현재 문서가 가장 높은 중요도를 가지는지 확인 */
				if (isMax(crnt[1], Q)) {
					order++;
					if (crnt[0] == M) {
						bw.write(order + "\n");
						bw.flush();
						break;
					}
				}
				/* 중요도가 높은 문서가 남아있다면 문서를 큐의 맨 뒤로 이동 */
				else {
					Q.add(crnt);
				}
			}

			T--;
		}
	}

	public static boolean isMax(int imprt, Queue<int[]> Q) {
		for (int[] dcmnt : Q) {
			/* 중요도가 높은 문서가 있을 경우 false 반환 */
			if (dcmnt[1] > imprt)
				return false;
		}

		/* 현재 문서가 가장 중요도가 높을 경우 true 반환 */
		return true;
	}

}
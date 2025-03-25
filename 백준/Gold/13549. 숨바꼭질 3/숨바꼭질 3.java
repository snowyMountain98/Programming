import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[] lctn;
		int N, K;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		lctn = new boolean[100001];

		lctn[N] = true;
		Q.add(new int[] { N, 0 });

		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			if (now[0] == K) {
				bw.write(now[1] + "\n");
				break;
			}

			/* BFS에서 순간이동(*2)을 먼저 확인하는 것이 빠른 탐색에 유리 */
			/* 0초 후에 2*X의 위치로 이동 */
			if (now[0] * 2 <= 100000 && !lctn[now[0] * 2]) {
				lctn[now[0] * 2] = true;
				Q.add(new int[] { now[0] * 2, now[1] });
			}

			/* 1초 후에 X-1의 위치로 이동 */
			if (0 <= now[0] - 1 && !lctn[now[0] - 1]) {
				lctn[now[0] - 1] = true;
				Q.add(new int[] { now[0] - 1, now[1] + 1 });
			}

			/* 1초 후에 X+1의 위치로 이동 */
			if (now[0] + 1 <= 100000 && !lctn[now[0] + 1]) {
				lctn[now[0] + 1] = true;
				Q.add(new int[] { now[0] + 1, now[1] + 1 });
			}
		}

		bw.flush();
	}

}
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
		int A, B;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		Q.offer(new int[] { A, 1 });

		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			if (now[0] == B) {
				bw.write(now[1] + "\n");
				bw.flush();
				System.exit(0);
			}

			/* 2를 곱한다 */
			if (now[0] <= 500000000)
				Q.offer(new int[] { now[0] * 2, now[1] + 1 });

			/* 1을 수의 가장 오른쪽에 추가한다 */
			if (now[0] < 100000000)
				Q.offer(new int[] { now[0] * 10 + 1, now[1] + 1 });
		}

		bw.write(-1 + "\n");    // 만들 수 없는 경우에는 -1을 출력
		bw.flush();
	}

}
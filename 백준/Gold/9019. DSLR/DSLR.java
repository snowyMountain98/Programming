import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/* 레지스터 상태 */
	static class Rgstr {
		int n;			// 현재 숫자
		String cmnd;	// 지금까지의 명령어 기록

		Rgstr(int n, String cmnd) {
			this.n = n;
			this.cmnd = cmnd;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, A, B;
		Queue<Rgstr> Q;
		boolean vstd[];

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			Q = new LinkedList<>();
			vstd = new boolean[10000];

			Q.add(new Rgstr(A, ""));
			vstd[A] = true;

			/* BFS 탐색 시작 */
			while (!Q.isEmpty()) {
				Rgstr now = Q.poll();

				/* 목표 숫자에 도달하면 명령어 출력 후 종료 */
				if (now.n == B) {
					bw.write(now.cmnd + "\n");
					bw.flush();
					break;
				}

				int next;

				/* D: n을 두 배로. 9999를 넘으면 10000으로 나눈 나머지 */
				next = now.n * 2;
				next = next > 9999 ? next % 10000 : next;
				if (!vstd[next]) {
					vstd[next] = true;
					Q.add(new Rgstr(next, now.cmnd + "D"));
				}

				/* S: n에서 1을 빼기. 0이면 9999로 */
				next = now.n - 1;
				next = next < 0 ? 9999 : next;
				if (!vstd[next]) {
					vstd[next] = true;
					Q.add(new Rgstr(next, now.cmnd + "S"));
				}

				/* L: 왼쪽으로 한 칸 회전 1234 → 2341 */
				next = (now.n * 10) % 10000 + now.n / 1000;
				if (!vstd[next]) {
					vstd[next] = true;
					Q.add(new Rgstr(next, now.cmnd + "L"));
				}

				/* R: 오른쪽으로 한 칸 회전 1234 → 4123 */
				next = (now.n % 10) * 1000 + (now.n / 10);
				if (!vstd[next]) {
					vstd[next] = true;
					Q.add(new Rgstr(next, now.cmnd + "R"));
				}
			}

			T--;
		}
	}

}
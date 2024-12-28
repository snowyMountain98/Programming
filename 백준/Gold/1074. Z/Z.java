import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, r, c, order = 0;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		/* Z 모양으로 탐색하여 해당 좌표(r, c)의 순서를 계산 */
		while (N > 0) {
			N--;

			/* 1사분면: r과 c가 각각 2^(N-1)보다 작을 때 */
			if (r < Math.pow(2, N) && c < Math.pow(2, N))
				continue;
			/* 2사분면: r은 2^(N-1)보다 작고 c는 2^(N-1) 이상일 때 */
			else if (r < Math.pow(2, N) && c >= Math.pow(2, N)) {
				order += Math.pow(Math.pow(2, N), 2);
				c -= Math.pow(2, N);
			}
			/* 3사분면: r은 2^(N-1) 이상이고 c는 2^(N-1)보다 작을 때 */
			else if (r >= Math.pow(2, N) && c < Math.pow(2, N)) {
				order += Math.pow(Math.pow(2, N), 2) * 2;
				r -= Math.pow(2, N);
			}
			/* 4사분면: r과 c가 각각 2^(N-1) 이상일 때 */
			else {
				order += Math.pow(Math.pow(2, N), 2) * 3;
				r -= Math.pow(2, N);
				c -= Math.pow(2, N);
			}

			/**************************************************
			 * 2 3 1
			 * ┌───┬───┬───┬───┐
			 * │ 0 │ 1 │ 4 │ 5 │
			 * ├───┼───┼───┼───┤		┌───┬───┐
			 * │ 2 │ 3 │ 6 │ 7 │		│ 8 │ 9 │
			 * ┢━━━┿━━━╅───┼───┤	→	├───╆━━━┪
			 * ┃ 8 │ 9 ┃ 12│ 13│		│ 10┃ 11┃
			 * ┠───┼───╂───┼───┤		└───┺━━━┛
			 * ┃ 10│ 11┃ 14│ 15│
			 * ┗━━━┷━━━┹───┴───┘
			 **************************************************/
		}

		bw.write(order + "\n");
		bw.flush();
	}

}
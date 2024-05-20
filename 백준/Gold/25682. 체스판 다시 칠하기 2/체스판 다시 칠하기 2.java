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
		int N, M, K, min = Integer.MAX_VALUE;
		char[][] board;
		int[][] dp_w, dp_b;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new char[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();

			for (int j = 1; j <= M; j++)
				board[i][j] = str.charAt(j - 1);
		}

		/**************************************************
		 * board :
		 * [B, B, B, B]
		 * [B, B, B, B]
		 * [B, B, B, W]
		 * [B, B, W, B]
		 **************************************************/

		dp_w = new int[N + 1][M + 1];
		dp_b = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				/* ⅱ) 맨 왼쪽 위 칸이 흰색인 경우 */
				if (((i + j) % 2 == 0 && board[i][j] == 'W') || ((i + j) % 2 == 1 && board[i][j] == 'B')) // 같을 때
					dp_w[i][j] = dp_w[i - 1][j] + dp_w[i][j - 1] - dp_w[i - 1][j - 1];
				else // 다를 때
					dp_w[i][j] = dp_w[i - 1][j] + dp_w[i][j - 1] - dp_w[i - 1][j - 1] + 1;

				/* ⅱ) 맨 왼쪽 위 칸이 검은색인 경우 */
				if (((i + j) % 2 == 0 && board[i][j] == 'B') || ((i + j) % 2 == 1 && board[i][j] == 'W')) // 같을 때
					dp_b[i][j] = dp_b[i - 1][j] + dp_b[i][j - 1] - dp_b[i - 1][j - 1];
				else // 다를 때
					dp_b[i][j] = dp_b[i - 1][j] + dp_b[i][j - 1] - dp_b[i - 1][j - 1] + 1;
			}
		}


		/**************************************************
		 * dp_w :		dp_b :
		 * [1, 1, 2, 2]		[0, 1, 1, 2]
		 * [1, 2, 3, 4]		[1, 2, 3, 4]
		 * [2, 3, 5, 7]		[1, 3, 4, 5]
		 * [2, 4, 7, 10]	[2, 4, 5, 6]
		 **************************************************/

		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				min = Math.min(min, dp_w[i][j] - dp_w[i][j - K] - dp_w[i - K][j] + dp_w[i - K][j - K]);
				min = Math.min(min, dp_b[i][j] - dp_b[i][j - K] - dp_b[i - K][j] + dp_b[i - K][j - K]);
			}
		}

		bw.write(min + "\n");
		bw.flush();
	}

}
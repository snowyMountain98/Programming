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
		int T, n;
		int[][] stckr, dp;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			n = Integer.parseInt(br.readLine());

			stckr = new int[2][n];
			dp = new int[2][n];

			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++)
					stckr[i][j] = Integer.parseInt(st.nextToken());
			}

			dp[0][0] = stckr[0][0];
			dp[1][0] = stckr[1][0];

			if (n > 1) {
				dp[0][1] = dp[1][0] + stckr[0][1];
				dp[1][1] = dp[0][0] + stckr[1][1];

				for (int i = 2; i < n; i++) {
					dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stckr[0][i];
					dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stckr[1][i];
				}
			}
			
			/**************************************************
			 * case 1.				case 2.
			 * ┏━━━┱───┲━━━┱───		┌───┬───┲━━━┱───
			 * ┃ O ┃ X ┃ O ┃ …		│ O │ X ┃ O ┃ …
			 * ┡━━━╋━━━╋━━━╃───		┢━━━╅───╄━━━╃───
			 * │ X ┃ O ┃ X │ …		┃ O ┃ O │ X │ …
			 * └───┺━━━┹───┴───		┗━━━┹───┴───┴───
			 **************************************************/

			bw.write(Math.max(dp[0][n - 1], dp[1][n - 1]) + "\n");
			T--;
		}

		bw.flush();
	}

}
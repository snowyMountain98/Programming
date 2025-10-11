import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int[] dp;

		N = Integer.parseInt(br.readLine());

		if (N % 2 == 1) {
			bw.write("0\n");
			bw.flush();
			System.exit(0);
		}

		dp = new int[N + 1];

		if (N > 1)
			dp[2] = 3;

		/********************
		 * ┌─┬─┐ ┌───┐ ┌───┐
		 * │ │ │ ├─┬─┤ ├───┤
		 * ├─┴─┤ │ │ │ ├───┤
		 * └───┘ └─┴─┘ └───┘
		 ********************/

		for (int i = 4; i <= N; i += 2) {
			dp[i] += dp[i - 2] * 3;

			for (int j = 4; j <= i - 2; j++)
				dp[i] += dp[i - j] * 2;

			dp[i] += 2;
		}

		/**************************************************
		 * ⅰ. dp[2] * dp[N-2]
		 * ┌───────┬─────────┐
		 * │ dp[2] │ dp[N-2] │
		 * └───────┴─────────┘
		 * 
		 * ⅱ. j특수모양 * dp[N-j]
		 * ┌─┬───┬─┬─────────┐ ┌───┬───┬─────────┐
		 * │ ├───┤ │         │ ├─┬─┴─┬─┤         │
		 * ├─┴─┬─┴─┤ dp[N-4] │ │ ├───┤ │ dp[N-4] │
		 * └───┴───┴─────────┘ └─┴───┴─┴─────────┘
		 * ┌─┬───┬───┬─┬─────────┐ ┌───┬───┬───┬─────────┐
		 * │ ├───┼───┤ │         │ ├─┬─┴─┬─┴─┬─┤         │
		 * ├─┴─┬─┴─┬─┴─┤ dp[N-6] │ │ ├───┼───┤ │ dp[N-6] │
		 * └───┴───┴───┴─────────┘ └─┴───┴───┴─┴─────────┘
		 * 
		 * ⅲ. N특수모양
		 * ┌─┬───┬   ┬───┬─┐ ┌───┬──   ──┬───┐
		 * │ ├───┼ … ┼───┤ │ ├─┬─┴─┬ … ┬─┴─┬─┤
		 * ├─┴─┬─┴   ┴─┬─┴─┤ │ ├───┼   ┼───┤ │
         * └───┴──   ──┴───┘ └─┴───┴   ┴───┴─┘
         **************************************************/

		bw.write(dp[N] + "\n");
		bw.flush();
	}

}
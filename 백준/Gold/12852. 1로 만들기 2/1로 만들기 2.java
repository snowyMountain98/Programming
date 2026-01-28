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
		int[][] dp;

		N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][2];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = Integer.MAX_VALUE;

			if (i % 3 == 0 && dp[i][0] > dp[i / 3][0] + 1) {
				dp[i][0] = dp[i / 3][0] + 1;
				dp[i][1] = i / 3;
			}

			if (i % 2 == 0 && dp[i][0] > dp[i / 2][0] + 1) {
				dp[i][0] = dp[i / 2][0] + 1;
				dp[i][1] = i / 2;
			}

			if (dp[i][0] > dp[i - 1][0] + 1) {
				dp[i][0] = dp[i - 1][0] + 1;
				dp[i][1] = i - 1;
			}
		}

		bw.write(dp[N][0] + "\n");

		bw.write(N + " ");

		int a = dp[N][1];

		while (a > 0) {
			bw.write(a + " ");
			a = dp[a][1];
		}

		bw.write("\n");
		bw.flush();
	}

}
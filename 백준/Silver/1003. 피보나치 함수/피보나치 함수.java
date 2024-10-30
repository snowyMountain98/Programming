import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T, N;
		int[][] dp = new int[41][2];

		T = Integer.parseInt(br.readLine());

		/**************************************************
		 * dp[i][0] : N이 i일 때 0이 호출되는 횟수
		 * dp[i][1] :     〃    1이 호출되는 횟수
		 **************************************************/
		dp[0][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		while (T > 0) {
			N = Integer.parseInt(br.readLine());

			bw.write(dp[N][0] + " " + dp[N][1] + "\n");
			bw.flush();

			T--;
		}
	}

}
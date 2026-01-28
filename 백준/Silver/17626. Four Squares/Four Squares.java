import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] dp;

		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;

			for (int j = 1; j * j <= i; j++)
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
		}

		bw.write(dp[n] + "\n");
		bw.flush();
	}

}
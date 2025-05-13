import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, k;
		int[] coin;
		int[] dp;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		coin = new int[n];
		dp = new int[k + 1];

		for (int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());

		for (int i = 1; i <= k; i++) {
			dp[i] = Integer.MAX_VALUE;

			for (int j = 0; j < n; j++) {
				if (i >= coin[j] && dp[i - coin[j]] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
			}
		}

		if (dp[k] == Integer.MAX_VALUE)
			bw.write("-1\n");
		else
			bw.write(dp[k] + "\n");
		bw.flush();
	}

}
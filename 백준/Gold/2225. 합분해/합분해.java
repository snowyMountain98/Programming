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
		int N, K;
		int[][] dp;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[K + 1][N + 1];

		for (int i = 0; i <= N; i++)
			dp[1][i] = 1;

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp[i][j] = 1;
					continue;
				}

				dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
			}
		}

		bw.write(dp[K][N] + "\n");
		bw.flush();
	}

}

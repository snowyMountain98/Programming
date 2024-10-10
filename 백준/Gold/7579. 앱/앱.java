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
		int N, M, maxCost = 0;
		int[] m, c;
		int[][] dp;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		m = new int[N + 1];
		for (int i = 1; i <= N; i++)
			m[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		c = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			maxCost += c[i];
		}

		/**********************************************************************
		 * dp[i][j]: i번째 앱까지 고려했을 때, j 비용으로 확보할 수 있는 최대 메모리 크기
		 * i: 현재 고려하고 있는 앱의 인덱스
		 * j: 현재까지 사용된 비용
		 **********************************************************************/
		dp = new int[N + 1][maxCost + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= maxCost; j++) {
				if (j >= c[i])
					dp[i][j] = Math.max(dp[i - 1][j - c[i]] + m[i], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		for (int i = 0; i <= maxCost; i++) {
			if (dp[N][i] >= M) {
				bw.write(i + "\n");
				bw.flush();
				break;
			}
		}
	}

}
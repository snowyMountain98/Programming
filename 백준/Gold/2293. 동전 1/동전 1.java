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
		int n, k, coin;
		int[] dp;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dp = new int[k + 1];
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			coin = Integer.parseInt(br.readLine());

			for (int j = coin; j <= k; j++)
				dp[j] = dp[j] + dp[j - coin];
		}
		
		/************************************************************
		 * coin ┃ 0 │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10
		 * ━━━━━╋━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━━
		 *   1  ┃ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │  1
		 * ─────╂───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼────
		 *   2  ┃ 1 │ 1 │ 2 │ 2 │ 3 │ 3 │ 4 │ 4 │ 5 │ 5 │  6
		 * ─────╂───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼────
		 *   5  ┃ 1 │ 1 │ 2 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 10
		 ************************************************************/

		bw.write(dp[k] + "\n");
		bw.flush();
	}

}
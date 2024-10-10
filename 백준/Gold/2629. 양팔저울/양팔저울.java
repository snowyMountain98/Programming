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
		int numWght, numBead, sum = 0;
		int[] wght, bead;
		boolean[][] dp;

		numWght = Integer.parseInt(br.readLine());
		wght = new int[numWght];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numWght; i++) {
			wght[i] = Integer.parseInt(st.nextToken());
			sum += wght[i];
		}

		numBead = Integer.parseInt(br.readLine());
		bead = new int[numBead];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < numBead; i++)
			bead[i] = Integer.parseInt(st.nextToken());

		dp = new boolean[numWght][sum + 1];

		dp[0][0] = true;
		dp[0][wght[0]] = true;

		for (int i = 1; i < numWght; i++) {
			for (int j = 0; j <= sum; j++) {
				if (dp[i - 1][j]) {
					dp[i][j] = true;
					dp[i][j + wght[i]] = true;
					dp[i][Math.abs(j - wght[i])] = true;
				}
			}
		}

		/************************************************************
		 *    ┃ 0 │ 1 │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │ 10 │ 11
		 * ━━━╋━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━━┿━━━━
		 *  2 ┃ T │ F │ T │ F │ F │ F │ F │ F │ F │ F │  F │  F
		 * ───╂───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼────┼────	
		 *  3 ┃ T │ T │ T │ T │ F │ T │ F │ F │ F │ F │  F │  F
		 * ───╂───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼────┼────
		 *  3 ┃ T │ T │ T │ T │ T │ T │ T │ F │ T │ F │  F │  F
		 * ───╂───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼────┼────
		 *  3 ┃ T │ T │ T │ T │ T │ T │ T │ T │ T │ T │  F │  T
		 ************************************************************/

		for (int i = 0; i < numBead; i++) {
			if (bead[i] <= sum && dp[numWght - 1][bead[i]])
				bw.write("Y ");
			else
				bw.write("N ");
		}
		bw.write("\n");

		bw.flush();
	}

}
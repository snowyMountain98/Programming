import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, k;
		int[] w, v;
		int[][] backpack;

		n = scn.nextInt();
		k = scn.nextInt();

		w = new int[n + 1];
		v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			w[i] = scn.nextInt();
			v[i] = scn.nextInt();
		}

		backpack = new int[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (w[j] <= i)
					backpack[i][j] = Math.max(backpack[i - w[j]][j - 1] + v[j], backpack[i][j - 1]);
				else
					backpack[i][j] = backpack[i][j - 1];
			}
		}

		/******************************
		 *    ┃ 0 │ 1 │ 2 │ 3 │ 4 
		 * ━━━╋━━━┿━━━┿━━━┿━━━┿━━━
		 *  0 ┃ 0 │ 0 │ 0 │ 0 │ 0
		 * ───╂───┼───┼───┼───┼─── 
		 *  1 ┃ 0 │ 0 │ 0 │ 0 │ 0
		 * ───╂───┼───┼───┼───┼───
		 *  2 ┃ 0 │ 0 │ 0 │ 0 │ 0
		 * ───╂───┼───┼───┼───┼───
		 *  3 ┃ 0 │ 0 │ 0 │ 6 │ 6
		 * ───╂───┼───┼───┼───┼───
		 *  4 ┃ 0 │ 0 │ 8 │ 8 │ 8
		 * ───╂───┼───┼───┼───┼───
		 *  5 ┃ 0 │ 0 │ 8 │ 8 │ 12
		 * ───╂───┼───┼───┼───┼───
		 *  6 ┃ 0 │ 13│ 13│ 13│ 13
		 * ───╂───┼───┼───┼───┼───
		 *  7 ┃ 0 │ 13│ 13│ 14│ 14
		 ******************************/

		System.out.println(backpack[k][n]);
	}

}
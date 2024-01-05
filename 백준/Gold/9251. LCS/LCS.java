import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1, str2;
		int[][] lngComSbs;

		str1 = scn.next();
		str2 = scn.next();

		lngComSbs = new int[str2.length() + 1][str1.length() + 1];

		for (int i = 1; i <= str2.length(); i++) {
			for (int j = 1; j <= str1.length(); j++) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1))
					lngComSbs[i][j] = lngComSbs[i - 1][j - 1] + 1;
				else
					lngComSbs[i][j] = Math.max(lngComSbs[i - 1][j], lngComSbs[i][j - 1]);
			}
		}
		
		/****************************************
		 *    │ - │ A │ C │ A │ Y │ K │ P
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  - │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  C │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  A │ 0 │ 1 │ 1 │ 2 │ 2 │ 2 │ 2
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  P │ 0 │ 1 │ 1 │ 2 │ 2 │ 2 │ 3
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  C │ 0 │ 1 │ 2 │ 2 │ 2 │ 2 │ 3
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  A │ 0 │ 1 │ 2 │ 3 │ 3 │ 3 │ 3
		 * ───┼───┼───┼───┼───┼───┼───┼───
		 *  K │ 0 │ 1 │ 2 │ 3 │ 3 │ 4 │ 4
		 ****************************************/

		System.out.println(lngComSbs[str2.length()][str1.length()]);
	}

}
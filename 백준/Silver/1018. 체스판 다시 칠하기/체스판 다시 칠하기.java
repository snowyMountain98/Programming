import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, m;
		char[][] board;
		int min = Integer.MAX_VALUE;
		int w_color, b_color;

		char[][] white = { 
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' } };

		char[][] black = {
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
				{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' } };

		n = scn.nextInt();
		m = scn.nextInt();

		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			for (int j = 0; j < str.length(); j++)
				board[i][j] = str.charAt(j);
		}

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				w_color = 0;
				b_color = 0;

				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						/* 맨 왼쪽 위 칸이 흰색인 경우 */
						if (white[k][l] != board[i + k][j + l])
							w_color++;

						/* 검은색인 경우 */
						if (black[k][l] != board[i + k][j + l])
							b_color++;
					}
				}

				min = Math.min(min, Math.min(w_color, b_color));
			}
		}

		System.out.println(min);

		scn.close();
	}

}
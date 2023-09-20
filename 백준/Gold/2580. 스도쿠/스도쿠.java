import java.util.Scanner;

public class Main {
	static int[][] sudoku = new int[9][9];
	static int zero;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = scn.nextInt();

				if (sudoku[i][j] == 0)
					zero++;
			}
		}

		fillSudoku(0);
	}

	public static void fillSudoku(int cnt) {
		if (cnt == zero) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					System.out.print(sudoku[i][j] + " ");
				System.out.println();
			}

			System.exit(0);
		}

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudoku[row][col] == 0) {
					CHECK:
					for (int num = 1; num <= 9; num++) {
						/* 가로, 세로 */
						for (int i = 0; i < 9; i++) {
							if (sudoku[row][i] == num || sudoku[i][col] == num)
								continue CHECK;
						}

						/* 정사각형 */
						for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
							for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
								if (sudoku[i][j] == num)
									continue CHECK;
							}
						}

						sudoku[row][col] = num;
						cnt++;
						fillSudoku(cnt);
						cnt--;
					}

					sudoku[row][col] = 0;
					return;
				}
			}
		}
	}
}
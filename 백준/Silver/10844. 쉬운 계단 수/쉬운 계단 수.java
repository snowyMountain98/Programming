import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[][] esyStr;
		int n, sum = 0;

		n = scn.nextInt();

		esyStr = new int[n + 1][10];	// int[자릿수][마지막 수]

		for (int i = 1; i < 10; i++)
			esyStr[1][i] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					esyStr[i][j] = esyStr[i - 1][1] % 1000000000;
				else if (j == 9)
					esyStr[i][j] = esyStr[i - 1][8] % 1000000000;
				else
					esyStr[i][j] = (esyStr[i - 1][j + 1] + esyStr[i - 1][j - 1]) % 1000000000;
			}
		}

		/****************************************
		 * n : 4
		 * esyStr :
		 * [[0, 1, 1, 1, 1, 1, 1, 1, 1, 1],
		 *  [1, 1, 2, 2, 2, 2, 2, 2, 2, 1],
		 *  [1, 3, 3, 4, 4, 4, 4, 4, 3, 2],
		 *  [3, 4, 7, 7, 8, 8, 8, 7, 6, 3]]
		 ****************************************/		
		
		for (int i = 0; i < 10; i++)
			sum = (sum + esyStr[n][i]) % 1000000000;

		System.out.println(sum);
	}

}
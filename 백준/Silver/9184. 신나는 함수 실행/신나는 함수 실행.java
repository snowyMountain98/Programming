import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long[][][] w;
		int a, b, c;

		w = new long[101][101][101];

		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++)
				for (int k = 0; k <= 100; k++) {
					if (i <= 50 || j <= 50 || k <= 50)
						w[i][j][k] = 1;
					else if (i > 70 || j > 70 || k > 70)
						w[i][j][k] = 1048576;
					else if (i < j && j < k)
						w[i][j][k] = w[i][j][k - 1] + w[i][j - 1][k - 1] - w[i][j - 1][k];
					else
						w[i][j][k] = w[i - 1][j][k] + w[i - 1][j - 1][k] + w[i - 1][j][k - 1] - w[i - 1][j - 1][k - 1];
				}
		}

		do {
			a = scn.nextInt();
			b = scn.nextInt();
			c = scn.nextInt();

			if (a == -1 && b == -1 && c == -1)
				break;

			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w[a + 50][b + 50][c + 50]);
		} while (true);
	}

}
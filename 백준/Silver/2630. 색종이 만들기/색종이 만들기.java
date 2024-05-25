import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static int[] color = new int[2];

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N;

		N = scn.nextInt();

		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				paper[i][j] = scn.nextInt();
		}

		cut(0, 0, N);

		System.out.println(color[0] + "\n" + color[1]);
	}

	public static void cut(int x, int y, int size) {
		/* 모두 하얀색 또는 모두 파란색 */
		if (allSameColor(x, y, size))
			color[paper[x][y]]++;
		/* 모두 같은 색으로 칠해져 있지 않으면 */
		else {
			cut(x, y, size / 2);							// I
			cut(x, y + (size / 2), size / 2);				// II
			cut(x + (size / 2), y, size / 2);				// III
			cut(x + (size / 2), y + (size / 2), size / 2);	// IV
		}
	}

	public static boolean allSameColor(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++)
				if (paper[i][j] != paper[x][y])
					return false;
		}

		return true;
	}
}
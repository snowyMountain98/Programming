import java.util.Scanner;

public class Main {
	static char[][] video;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N;

		N = scn.nextInt();

		video = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = scn.next();
			
			for (int j = 0; j < N; j++)
				video[i][j] = str.charAt(j);
		}

		cmprs(0, 0, N);

		System.out.println(sb.toString());
	}

	/* 압축 */
	public static void cmprs(int x, int y, int size) {
		/* 모두 0 또는 모두 1 */
		if (allSame(x, y, size))
			sb.append(video[x][y]);
		/* 0과 1이 섞여 있으면 */
		else {
			sb.append("(");
			cmprs(x, y, size / 2);					// 왼쪽 위
			cmprs(x, y + (size / 2), size / 2);			// 오른쪽 위
			cmprs(x + (size / 2), y, size / 2);			// 왼쪽 아래
			cmprs(x + (size / 2), y + (size / 2), size / 2);	// 오른쪽 아래
			sb.append(")");
		}
	}

	public static boolean allSame(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++)
				if (video[i][j] != video[x][y])
					return false;
		}

		return true;
	}
}
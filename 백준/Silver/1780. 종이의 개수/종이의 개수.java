import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] paper;
	static int[] number = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;

		N = Integer.parseInt(br.readLine());

		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}

		cut(0, 0, N);

		bw.write(number[0] + "\n" + number[1] + "\n" + number[2] + "\n");
		bw.flush();
	}

	public static void cut(int x, int y, int size) {
		/* 1. 종이가 모두 같은 수로 되어 있다면 */
		if (allSame(x, y, size))
			number[paper[x][y] + 1]++;
		/* 2. (1)이 아닌 경우 */
		else {
			/* 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복 */
			for (int i = x; i < x + size; i += size / 3) {
				for (int j = y; j < y + size; j += size / 3)
					cut(i, j, size / 3);
			}
		}
	}

	public static boolean allSame(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++)
				if (paper[i][j] != paper[x][y])
					return false;
		}

		return true;
	}
}
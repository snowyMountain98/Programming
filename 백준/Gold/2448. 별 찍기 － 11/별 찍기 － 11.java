import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		star = new char[N + 1][2 * N];

		/* 별 배열을 전부 공백(' ')으로 초기화 */
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < 2 * N; j++)
				star[i][j] = ' ';
		}

		/* 가장 큰 삼각형의 꼭대기 좌표에서 재귀적으로 별을 찍음 */
		printStar(N, 1, N);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j < 2 * N; j++)
				bw.write(star[i][j]);

			bw.write("\n");
		}
		bw.flush();
	}

	/**
	 * 별을 재귀적으로 그리는 함수
	 * @param x: 삼각형의 중앙 x 좌표
	 * @param y: 삼각형의 시작 y 좌표
	 * @param n: 삼각형의 높이
	 */
	public static void printStar(int x, int y, int n) {
		/* 삼각형의 최소 단위 (높이 3) */
		if (n == 3) {
			star[y][x] = '*';	// 첫 줄 (꼭대기)
			star[y + 1][x - 1] = star[y + 1][x + 1] = '*';	// 두 번째 줄
			star[y + 2][x - 2] = star[y + 2][x - 1] = star[y + 2][x] = star[y + 2][x + 1] = star[y + 2][x + 2] = '*';	// 세 번째 줄
		}
		/* 삼각형을 3개의 작은 삼각형으로 분할 */
		else {
			n /= 2;
			printStar(x, y, n);	// 위쪽 삼각형
			printStar(x - n, y + n, n);	// 왼쪽 아래 삼각형
			printStar(x + n, y + n, n);	// 오른쪽 아래 삼각형
		}
	}
}
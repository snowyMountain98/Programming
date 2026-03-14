import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static char[][] candy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int max = 0;

		N = Integer.parseInt(br.readLine());

		candy = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++)
				candy[i][j] = str.charAt(j);
		}

		/* 모든 위치에서 사탕 교환 시도 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				/* 오른쪽 사탕과 교환 가능한 경우 */
				if (j + 1 < N && candy[i][j] != candy[i][j + 1]) {
					exchange(1, i, j);

					max = Math.max(max, bomboni());

					exchange(1, i, j);
				}

				/* 아래쪽 사탕과 교환 가능한 경우 */
				if (i + 1 < N && candy[i][j] != candy[i + 1][j]) {
					exchange(2, i, j);

					max = Math.max(max, bomboni());

					exchange(2, i, j);
				}
			}
		}

		bw.write(max + "\n");
		bw.flush();
	}

	/**
	 * 사탕 교환
	 */
	public static void exchange(int direction, int y, int x) {
		char tmp;

		switch (direction) {
		case 1:
			tmp = candy[y][x];
			candy[y][x] = candy[y][x + 1];
			candy[y][x + 1] = tmp;
			break;
		case 2:
			tmp = candy[y][x];
			candy[y][x] = candy[y + 1][x];
			candy[y + 1][x] = tmp;
			break;
		}
	}

	/**
	 * 현재 보드에서 가장 긴 연속 사탕 개수
	 */
	public static int bomboni() {
		int max = 0;

		/* 모든 행과 열 검사 */
		for (int i = 0; i < N; i++) {
			int cnt = 1;

			/* 가로 방향 검사 */
			for (int j = 1; j < N; j++) {
				/* 이전 사탕과 같은 색이면 연속 증가 */
				if (candy[i][j - 1] == candy[i][j]) {
					cnt++;
					max = Math.max(max, cnt);
				}
				/* 다른 색이면 연속 초기화 */
				else
					cnt = 1;
			}

			cnt = 1;

			/* 세로 방향 검사 */
			for (int j = 1; j < N; j++) {
				/* 위쪽 사탕과 같은 색이면 연속 증가 */
				if (candy[j - 1][i] == candy[j][i]) {
					cnt++;
					max = Math.max(max, cnt);
				}
				/* 다른 색이면 연속 초기화 */
				else
					cnt = 1;
			}
		}

		return max;
	}
}
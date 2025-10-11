import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> dust;
	static ArrayList<Integer> airPrfr = new ArrayList<>();
	static int R, C, T;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static int[][] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		A = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < C; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());

				if (A[i][j] == -1)
					airPrfr.add(i);
			}
		}

		/* T초 동안 시뮬레이션 진행 */
		while (T > 0) {
			sprdDust();

			oprtAirPrfr();

			T--;
		}

		/* 남은 미세먼지 양 계산 */
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				if (A[i][j] != -1)
					sum += A[i][j];
		}

		bw.write(sum + "\n");
		bw.flush();
	}

	/**
	 * 먼지 확산
	 */
	public static void sprdDust() {
		dust = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				if (A[i][j] > 0)
					dust.add(new int[] { j, i, A[i][j] });
		}

		for (int[] d : dust) {
			int x = d[0], y = d[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				/* 격자 범위를 벗어나거나 공기청정기 위치면 확산 X */
				if (nx < 0 || nx >= C || ny < 0 || ny >= R || A[ny][nx] == -1)
					continue;

				/* 확산되는 양은 ⌊Ar,c/5⌋ */
				A[ny][nx] += d[2] / 5;

				/* 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) */
				A[y][x] -= d[2] / 5;
				A[y][x] = A[y][x] < 0 ? 0 : A[y][x];
			}
		}
	}

	/**
	 * 공기청정기 작동
	 */
	public static void oprtAirPrfr() {
		int top = airPrfr.get(0), bottom = airPrfr.get(1);

		/* 위쪽 (반시계 방향 순환) */
		for (int i = top - 1; i > 0; i--)
			A[i][0] = A[i - 1][0];

		for (int i = 0; i < C - 1; i++)
			A[0][i] = A[0][i + 1];

		for (int i = 0; i < top; i++)
			A[i][C - 1] = A[i + 1][C - 1];

		for (int i = C - 1; i > 1; i--)
			A[top][i] = A[top][i - 1];

		A[top][1] = 0;		// 공기청정기에서 나오는 공기

		/* 아래쪽 (시계 방향 순환) */
		for (int i = bottom + 1; i < R - 1; i++)
			A[i][0] = A[i + 1][0];

		for (int i = 0; i < C - 1; i++)
			A[R - 1][i] = A[R - 1][i + 1];

		for (int i = R - 1; i > bottom; i--)
			A[i][C - 1] = A[i - 1][C - 1];

		for (int i = C - 1; i > 1; i--)
			A[bottom][i] = A[bottom][i - 1];

		A[bottom][1] = 0;	// 공기청정기에서 나오는 공기
	}

}
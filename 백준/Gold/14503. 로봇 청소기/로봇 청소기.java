import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, cnt = 0;;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		int r, c, d;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 청소 시작 */
		map[r][c] = 2;
		cnt++;
		clean(r, c, d);

	}

	/************************************************************************************************************************
	 * 1 1 0			2 1 2				2 2 1				1 2 0
	 * ┌───┬───┬───┬───┐		┌───┬───┬───┬───┐		┌───┬───┬───┬───┐		┌───┬───┬───┬───┐
	 * │ 1 │ 1 │ 1 │ 1 │		│ 1 │ 1 │ 1 │ 1 │		│ 1 │ 1 │ 1 │ 1 │		│ 1 │ 1 │ 1 │ 1 │
	 * ├───╆━━━╅───┼───┤		├───┼───┼───┼───┤		├───┼───┼───┼───┤		├───┼───╆━━━╅───┤
	 * │ 1 ┃ 2 ┃ 0 │ 0 │		│ 1 │ 2 │ 0 │ 0 │		│ 1 │ 2 │ 0 │ 0 │		│ 1 │ 2 ┃ 2 ┃ 0 │
	 * ├───╄━━━╃───┼───┤	→	├───╆━━━╅───┼───┤	→	├───┼───╆━━━╅───┤	→	├───┼───╄━━━╃───┤	→
	 * │ 1 │ 0 │ 0 │ 0 │		│ 1 ┃ 2 ┃ 0 │ 0 │		│ 1 │ 2 ┃ 2 ┃ 0 │		│ 1 │ 2 │ 2 │ 0 │
	 * ├───┼───┼───┼───┤		├───╄━━━╃───┼───┤		├───┼───╄━━━╃───┤		├───┼───┼───┼───┤
	 * │ 1 │ 0 │ 0 │ 1 │		│ 1 │ 0 │ 0 │ 1 │		│ 1 │ 0 │ 0 │ 1 │		│ 1 │ 0 │ 0 │ 1 │
	 * └───┴───┴───┴───┘		└───┴───┴───┴───┘		└───┴───┴───┴───┘		└───┴───┴───┴───┘
	 * 1 3 1			2 3 2				1 3 2
	 * ┌───┬───┬───┬───┐		┌───┬───┬───┬───┐		┌───┬───┬───┬───┐
	 * │ 1 │ 1 │ 1 │ 1 │		│ 1 │ 1 │ 1 │ 1 │		│ 1 │ 1 │ 1 │ 1 │
	 * ├───┼───┼───╆━━━┧		├───┼───┼───┼───┤		├───┼───┼───╆━━━┧
	 * │ 1 │ 2 │ 2 ┃ 2 ┃		│ 1 │ 2 │ 2 │ 2 │		│ 1 │ 2 │ 2 ┃ 2 ┃
	 * ├───┼───┼───╄━━━┦	→	├───┼───┼───╆━━━┧	→	├───┼───┼───╄━━━┦
	 * │ 1 │ 2 │ 2 │ 0 │		│ 1 │ 2 │ 2 ┃ 2 ┃		│ 1 │ 2 │ 2 │ 2 │
	 * ├───┼───┼───┼───┤		├───┼───┼───╄━━━┦		├───┼───┼───┼───┤
	 * │ 1 │ 0 │ 0 │ 1 │		│ 1 │ 0 │ 0 │ 1 │		│ 1 │ 0 │ 0 │ 1 │
	 * └───┴───┴───┴───┘		└───┴───┴───┴───┘		└───┴───┴───┴───┘
	 ************************************************************************************************************************/

	public static void clean(int r, int c, int d) throws IOException {
		int nx, ny, nd;
		int bx, by, bd;

		/* 네 방향을 모두 확인 (반시계 방향으로 회전하면서 확인) */
		for (int i = 1; i <= 4; i++) {
			nd = d - i < 0 ? d - i + 4 : d - i;
			nx = c + dx[nd];
			ny = r + dy[nd];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;

			if (map[ny][nx] >= 1)
				continue;

			/* 새로운 위치를 청소하고 재귀 호출 */
			map[ny][nx] = 2;
			cnt++;
			clean(ny, nx, nd);
		}

		/* 네 방향 모두 청소가 불가능한 경우 후진 */
		bd = d - 2 < 0 ? d + 2 : d - 2;
		bx = c + dx[bd];
		by = r + dy[bd];

		/* 후진이 불가능하면 청소 종료 */
		if (bx < 0 || bx >= M || by < 0 || by >= N || map[by][bx] == 1) {
			bw.write(cnt + "\n");
			bw.flush();
			System.exit(0);
		}

		/* 후진이 가능하면 후진 후 같은 방향으로 계속 탐색 */
		clean(by, bx, d);
	}

}

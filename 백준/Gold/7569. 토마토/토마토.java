import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, 0, -1, 0, 0, 0 };
	static int[] dy = { 0, -1, 0, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M, N, H, day = Integer.MIN_VALUE;
		int[][][] tmt;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tmt = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < M; k++)
					tmt[i][j][k] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++)
				for (int k = 0; k < M; k++)
					if (tmt[i][j][k] == 1)
						Q.add(new int[] { k, j, i });
		}

		while (!Q.isEmpty()) {
			int[] crnt = Q.poll();
			int x = crnt[0], y = crnt[1], z = crnt[2];

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
					if (tmt[nz][ny][nx] == 0) {
						tmt[nz][ny][nx] = tmt[z][y][x] + 1;
						Q.add(new int[] { nx, ny, nz });
					}
				}
			}
		}

		/************************************************************
		 * ┏━━━┯━━━┯━━━┯━━━┯━━━┓		┏━━━┯━━━┯━━━┯━━━┯━━━┓
		 * ┃ 0 │ 0 │ 0 │ 0 │ 0 ┃		┃ 5 │ 4 │ 3 │ 4 │ 5 ┃
		 * ┠───┼───┼───┼───┼───┨		┠───┼───┼───┼───┼───┨
		 * ┃ 0 │ 0 │ 0 │ 0 │ 0 ┃		┃ 4 │ 3 │ 2 │ 3 │ 4 ┃
		 * ┠───┼───┼───┼───┼───┨		┠───┼───┼───┼───┼───┨
		 * ┃ 0 │ 0 │ 0 │ 0 │ 0 ┃		┃ 5 │ 4 │ 3 │ 4 │ 5 ┃
		 * ┣━━━┿━━━┿━━━┿━━━┿━━━┫	→	┣━━━┿━━━┿━━━┿━━━┿━━━┫
		 * ┃ 0 │ 0 │ 0 │ 0 │ 0 ┃		┃ 4 │ 3 │ 2 │ 3 │ 4 ┃
		 * ┠───┼───┼───┼───┼───┨		┠───┼───┼───┼───┼───┨
		 * ┃ 0 │ 0 │ 1 │ 0 │ 0 ┃		┃ 3 │ 2 │ 1 │ 2 │ 3 ┃
		 * ┠───┼───┼───┼───┼───┨		┠───┼───┼───┼───┼───┨
		 * ┃ 0 │ 0 │ 0 │ 0 │ 0 ┃		┃ 4 │ 3 │ 2 │ 3 │ 4 ┃
		 * ┗━━━┷━━━┷━━━┷━━━┷━━━┛		┗━━━┷━━━┷━━━┷━━━┷━━━┛
		 ************************************************************/

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tmt[i][j][k] == 0) {
						bw.write("-1\n");
						bw.flush();
						System.exit(0);
					}

					day = Math.max(day, tmt[i][j][k]);
				}
			}
		}

		bw.write(day - 1 + "\n");
		bw.flush();
	}

}
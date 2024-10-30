import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] tmt;
	static Queue<int[]> queue = new LinkedList<>();
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int day = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tmt = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				tmt[i][j] = Integer.parseInt(st.nextToken());

				if (tmt[i][j] == 1)
					queue.add(new int[] { j, i });
			}
		}

		bfs();

		/**************************************************
		 * before :
		 * ┌───┬────┬───┬───┬────┬───┐
		 * │ 1 │ -1 │ 0 │ 0 │  0 │ 0 │
		 * ├───┼────┼───┼───┼────┼───┤
		 * │ 0 │ -1 │ 0 │ 0 │  0 │ 0 │
		 * ├───┼────┼───┼───┼────┼───┤
		 * │ 0 │  0 │ 0 │ 0 │ -1 │ 0 │
		 * ├───┼────┼───┼───┼────┼───┤
		 * │ 0 │  0 │ 0 │ 0 │ -1 │ 1 │
		 * └───┴────┴───┴───┴────┴───┘
		 * 
		 * after :
		 * ┌───┬────┬───┬───┬────┬───┐
		 * │ 1 │ -1 │ 7 │ 6 │  5 │ 4 │
		 * ├───┼────┼───┼───┼────┼───┤
		 * │ 2 │ -1 │ 6 │ 5 │  4 │ 3 │
		 * ├───┼────┼───┼───┼────┼───┤
		 * │ 3 │  4 │ 5 │ 6 │ -1 │ 2 │
		 * ├───┼────┼───┼───┼────┼───┤
		 * │ 4 │  5 │ 6 │ 7 │ -1 │ 1 │
		 * └───┴────┴───┴───┴────┴───┘
		 **************************************************/

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmt[i][j] == 0) {
					bw.write("-1\n");
					bw.flush();
					System.exit(0);
				}

				day = Math.max(day, tmt[i][j]);
			}
		}

		bw.write(day - 1 + "\n");
		bw.flush();
	}

	public static void bfs() {
		int nx, ny;

		while (!queue.isEmpty()) {
			int[] crnt = queue.poll();
			int x = crnt[0];
			int y = crnt[1];

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (tmt[ny][nx] == 0) {
						tmt[ny][nx] = tmt[y][x] + 1;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
	}

}
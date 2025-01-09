import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] vstd;
	static int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int islnd;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			vstd = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			islnd = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !vstd[i][j]) {
						islnd++;
						vstd[i][j] = true;
						dfs(j, i);
					}
				}
			}

			bw.write(islnd + "\n");
		}

		bw.flush();
	}

	public static void dfs(int x, int y) {
		int nx, ny;

		for (int i = 0; i < 8; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
				if (map[ny][nx] == 1 && !vstd[ny][nx]) {
					vstd[ny][nx] = true;
					dfs(nx, ny);
				}
			}
		}
	}

}
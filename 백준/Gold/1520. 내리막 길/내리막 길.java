import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		H = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				H[i][j] = -1;
			}
		}

		/**************************************************
		 * H :
		 * [3,  2,  2, 2,  1]
		 * [1, -1, -1, 1,  1]
		 * [1, -1, -1, 1, -1]
		 * [1,  1,  1, 1, -1]
		 **************************************************/

		bw.write(dfs(0, 0) + "\n");
		bw.flush();
	}

	public static int dfs(int x, int y) {
		int nx, ny;

		if (x == M - 1 && y == N - 1)
			return 1;

		if (H[x][y] != -1)
			return H[x][y];

		H[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N)
				continue;

			if (map[nx][ny] < map[x][y])
				H[x][y] += dfs(nx, ny);
		}

		return H[x][y];
	}
}
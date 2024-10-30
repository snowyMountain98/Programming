import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][] field;
	static boolean[][] vstd;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, K, X, Y, worm;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			field = new int[N][M];
			vstd = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				X = Integer.parseInt(st.nextToken());
				Y = Integer.parseInt(st.nextToken());

				field[Y][X] = 1;
			}

			worm = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1 && !vstd[i][j]) {
						worm++;
						vstd[i][j] = true;
						dfs(i, j);
					}
				}
			}

			bw.write(worm + "\n");
			bw.flush();

			T--;
		}

	}

	public static void dfs(int y, int x) {
		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				if (field[ny][nx] == 1 && !vstd[ny][nx]) {
					vstd[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
	}

}
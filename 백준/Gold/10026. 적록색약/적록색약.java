import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static boolean[][] vstd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		int n = 0, c = 0;		// n: 일반 구역 수, c: 적록색약 구역 수
		char[][] nrml, colorWkns;	// nrml: 일반 그림, colorWkns: 적록색약 그림

		N = Integer.parseInt(br.readLine());

		nrml = new char[N][N];
		colorWkns = new char[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine();

			for (int j = 0; j < N; j++) {
				nrml[i][j] = str.charAt(j);
				/* 적록색약인 경우 G를 R로 변환하여 저장 */
				colorWkns[i][j] = nrml[i][j] == 'G' ? 'R' : nrml[i][j];
			}
		}
		
		/**************************************************
		 * nrml :		colorWkns :
		 * [R, R, R, B, B]	[R, R, R, B, B]
		 * [G, G, B, B, B]	[R, R, B, B, B]
		 * [B, B, B, R, R]	[B, B, B, R, R]
		 * [B, B, R, R, R]	[B, B, R, R, R]
		 * [R, R, R, R, R]	[R, R, R, R, R]
		 **************************************************/

		/* 일반 구역 수 계산 */
		vstd = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vstd[i][j]) {
					vstd[i][j] = true;
					n++;
					dfs(j, i, nrml);
				}
			}
		}

		/* 적록색약 구역 수 계산 */
		vstd = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!vstd[i][j]) {
					vstd[i][j] = true;
					c++;
					dfs(j, i, colorWkns);
				}
			}
		}

		bw.write(n + " " + c + "\n");
		bw.flush();
	}

	public static void dfs(int x, int y, char[][] drwng) {
		int nx, ny;

		/* 상하좌우로 이동하며 연결된 구역 탐색 */
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			/* 그림의 범위를 벗어나지 않고 */
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				/* 방문하지 않았고, 현재 구역과 같은 색상이라면 */
				if (!vstd[ny][nx] && drwng[y][x] == drwng[ny][nx]) {
					vstd[ny][nx] = true;
					dfs(nx, ny, drwng);
				}
			}
		}
	}

}

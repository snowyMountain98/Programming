import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int N, cmplxNum;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] house;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++)
				map[i][j] = str.charAt(j) - '0';
		}

		/* 모든 좌표를 탐색하며, 단지가 발견되면 DFS 탐색을 시작 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cmplxNum++;
					map[i][j] = cmplxNum;
					visited[i][j] = true;
					dfs(i, j);
				}
			}
		}

		/**************************************************
		 * map :
		 * [0, 1, 1, 0, 2, 0, 0]
		 * [0, 1, 1, 0, 2, 0, 2]
		 * [1, 1, 1, 0, 2, 0, 2]
		 * [0, 0, 0, 0, 2, 2, 2]
		 * [0, 3, 0, 0, 0, 0, 0]
		 * [0, 3, 3, 3, 3, 3, 0]
		 * [0, 3, 3, 3, 0, 0, 0]
		 **************************************************/

		/* 각 좌표에 할당된 단지 번호를 통해 집의 수를 증가 */
		house = new int[cmplxNum + 1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				if (map[i][j] != 0)
					house[map[i][j]]++;
		}

		Arrays.sort(house);

		bw.write(cmplxNum + "\n");
		for (int i = 1; i <= cmplxNum; i++)
			bw.write(house[i] + "\n");
		bw.flush();
	}

	public static void dfs(int y, int x) {
		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			/* 다음 좌표가 지도의 범위 안에 있고, 집이 있으며, 아직 방문하지 않은 경우 */
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[ny][nx] == 1 && !visited[ny][nx]) {
					map[ny][nx] = cmplxNum;
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}
	}

}
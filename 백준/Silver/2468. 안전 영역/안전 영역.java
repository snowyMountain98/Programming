import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] area;
	static boolean[][] vstd;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int safeTrtry = 0;

		N = Integer.parseInt(br.readLine());

		area = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				/* 각 칸의 높이를 비교하여 최소값과 최대값 갱신 */
				min = Math.min(min, area[i][j]);
				max = Math.max(max, area[i][j]);
			}
		}

		/* 최소 높이부터 최대 높이까지 각 경우에 대해 안전 영역의 개수를 계산 */
		for (int k = min - 1; k < max; k++) {
			int cnt = 0;
			vstd = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					/* 현재 위치가 강수량보다 높고 방문하지 않았다면 새로운 안전 영역 */
					if (area[i][j] > k && !vstd[i][j]) {
						cnt++;
						vstd[i][j] = true;
						dfs(k, j, i);
					}
				}
			}

			/* 현재 강수량에서의 안전 영역 개수를 최대값과 비교하여 갱신 */
			safeTrtry = Math.max(safeTrtry, cnt);
		}

		bw.write(safeTrtry + "\n");
		bw.flush();
	}

	/* 깊이 우선 탐색(DFS)을 통해 연결된 안전 영역을 탐색 */
	public static void dfs(int rnfl, int x, int y) {
		int nx, ny;

		/* 상하좌우 네 방향으로 탐색 */
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			/* 범위를 벗어나지 않고, 강수량보다 높으며, 아직 방문하지 않았다면 */
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (area[ny][nx] > rnfl && !vstd[ny][nx]) {
					vstd[ny][nx] = true;
					dfs(rnfl, nx, ny);
				}
			}
		}
	}

}
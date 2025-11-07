import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[][] vstd;
		int n, m;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
		int[][] map, dstnc;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dstnc = new int[n][m];
		vstd = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dstnc[i][j] = map[i][j];

				/* 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1 */
				if (map[i][j] == 1)
					dstnc[i][j] = -1;

				/* 시작점을 큐에 넣고 초기화 */
				if (map[i][j] == 2) {
					vstd[i][j] = true;
					dstnc[i][j] = 0;
					Q.offer(new int[] { i, j, 0 });
				}
			}
		}

		/* BFS */
		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			/* 4방향 탐색 */
			for (int i = 0; i < 4; i++) {
				int nx = now[1] + dx[i];
				int ny = now[0] + dy[i];

				/* 범위 밖이거나, 갈 수 없는 곳인 경우 스킵 */
				if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] == 0)
					continue;

				/* 이미 방문한 곳이면 스킵 */
				if (vstd[ny][nx])
					continue;

				/* 방문 처리 및 거리 계산 */
				vstd[ny][nx] = true;
				dstnc[ny][nx] = now[2] + 1;	// 이전 칸 거리 + 1
				Q.offer(new int[] { ny, nx, dstnc[ny][nx] });
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				bw.write(dstnc[i][j] + " ");
			bw.write("\n");
		}

		bw.flush();
	}

}
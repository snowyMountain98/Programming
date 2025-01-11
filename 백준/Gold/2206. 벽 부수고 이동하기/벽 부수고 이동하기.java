import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Lctn {
		int x, y, dstnc, wall;

		public Lctn(int x, int y, int dstnc, int wall) {
			this.x = x;			// x 좌표
			this.y = y;			// y 좌표
			this.dstnc = dstnc;	// 현재까지 이동 거리
			this.wall = wall;	// 벽을 부쉈는지 여부 (0: 안 부숨, 1: 부숨)
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
		int[][] map;
		boolean[][][] vstd;
		Queue<Lctn> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		vstd = new boolean[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();

			for (int j = 1; j <= M; j++)
				map[i][j] = str.charAt(j - 1) - '0';
		}

		vstd[1][1][0] = true;
		Q.offer(new Lctn(1, 1, 1, 0));

		/* BFS 탐색 시작 */
		while (!Q.isEmpty()) {
			Lctn now = Q.poll();

			/* 목적지에 도달한 경우 거리 출력 후 종료 */
			if (now.x == M && now.y == N) {
				bw.write(now.dstnc + "\n");
				bw.flush();
				System.exit(0);
			}

			/* 4방향 탐색 */
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				/* 맵 범위를 벗어난 경우 스킵 */
				if (nx <= 0 || nx > M || ny <= 0 || ny > N)
					continue;

				/* 이동 가능한 빈 칸일 때 */
				if (map[ny][nx] == 0 && !vstd[ny][nx][now.wall]) {
					vstd[ny][nx][now.wall] = true;
					Q.offer(new Lctn(nx, ny, now.dstnc + 1, now.wall));
				}
				/* 벽을 만났을 때 (아직 벽을 부순 적이 없는 경우) */
				else if (map[ny][nx] == 1 && now.wall != 1 && !vstd[ny][nx][1]) {
					vstd[ny][nx][1] = true;
					Q.offer(new Lctn(nx, ny, now.dstnc + 1, 1));
				}
			}
		}

		/* 목적지에 도달하지 못한 경우 -1 출력 */
		bw.write("-1\n");
		bw.flush();
	}

}
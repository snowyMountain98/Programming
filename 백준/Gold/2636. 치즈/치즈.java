import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<int[]> cheese;
		boolean[][] vstd;
		int N, M, hour = 0, cnt = 0;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
		int[][] plate;
		Queue<int[]> Q;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		plate = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				plate[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 치즈가 모두 없어질 때까지 반복 */
		do {
			hour++;

			cheese = new ArrayList<>();
			vstd = new boolean[N][M];
			Q = new LinkedList<>();

			/* (0,0)에서 BFS 시작 */
			vstd[0][0] = true;
			Q.add(new int[] { 0, 0 });

			/* BFS 수행 */
			while (!Q.isEmpty()) {
				int[] now = Q.poll();

				/* 4방향 탐색 */
				for (int i = 0; i < 4; i++) {
					int nx = now[1] + dx[i];
					int ny = now[0] + dy[i];

					/* 범위 밖이면 패스 */
					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						continue;

					/* 이미 방문한 곳이면 패스 */
					if (vstd[ny][nx])
						continue;

					/* 빈칸(공기)이면 계속 BFS */
					if (plate[ny][nx] == 0) {
						vstd[ny][nx] = true;
						Q.add(new int[] { ny, nx });
					}
					/* 치즈를 만난 경우 */
					else {
						/* 이번 턴에 녹일 치즈로 등록 */
						cheese.add(new int[] { ny, nx });
						vstd[ny][nx] = true;
					}
				}
			}

			/* 외부 공기와 닿아있던 치즈를 모두 녹임 */
			if (cheese.size() != 0) {
				cnt = cheese.size();

				for (int i = 0; i < cheese.size(); i++) {
					int[] c = cheese.get(i);

					plate[c[0]][c[1]] = 0;
				}
			}
		} while (cheese.size() > 0);

		bw.write((hour - 1) + "\n" + cnt + "\n");
		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class BabyShark implements Comparable<BabyShark> {
		int x, y, dstnc;

		public BabyShark(int x, int y, int dstnc) {
			this.x = x;
			this.y = y;
			this.dstnc = dstnc;
		}

		@Override
		public int compareTo(BabyShark o) {
			/* 가장 위에 있는 물고기가 많다면, 가장 왼쪽에 있는 물고기 */
			if (this.dstnc == o.dstnc && this.y == o.y)
				return this.x - o.x;
			/* 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기 */
			else if (this.dstnc == o.dstnc)
				return this.y - o.y;
			/* 거리가 가장 가까운 물고기 */
			else
				return this.dstnc - o.dstnc;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[][] vstd;
		int N, size, eatCnt, d = 0;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
		int[][] space;
		PriorityQueue<BabyShark> pQ = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		vstd = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				space[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (space[i][j] == 9) {	// 아기 상어 위치 발견
					pQ.add(new BabyShark(j, i, 0));
					space[i][j] = 0;
					vstd[i][j] = true;
				}
			}
		}

		size = 2;	// 가장 처음 아기 상어의 크기는 2
		eatCnt = 0;

		/* BFS 탐색 시작 */
		while (!pQ.isEmpty()) {
			BabyShark now = pQ.poll();

			/* 먹을 수 있는 물고기라면 */
			if (space[now.y][now.x] != 0 && space[now.y][now.x] < size) {
				eatCnt++;	// 먹은 개수 증가

				/* 자신의 크기만큼 물고기를 먹었다면 크기 증가 */
				if (eatCnt == size) {
					size++;
					eatCnt = 0;
				}

				space[now.y][now.x] = 0;	// 물고기 먹었으므로 해당 위치 0으로 초기화
				d += now.dstnc;	// 이동 거리 누적

				/* BFS 초기화 (새로운 물고기 탐색을 위해 큐와 방문 배열 초기화) */
				pQ = new PriorityQueue<>();
				pQ.add(new BabyShark(now.x, now.y, 0));
				vstd = new boolean[N][N];
				vstd[now.y][now.x] = true;

				continue;	// 다음 탐색 진행
			}

			/* 네 방향 탐색 */
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				/* 공간을 벗어나면 무시 */
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				/* 방문했거나 아기 상어보다 큰 물고기가 있는 경우 이동 불가 */
				if (space[ny][nx] > size || vstd[ny][nx])
					continue;

				/* 이동 가능하면 방문 처리 후 큐에 추가 */
				vstd[ny][nx] = true;
				pQ.add(new BabyShark(nx, ny, now.dstnc + 1));
			}
		}

		bw.write(d + "\n");
		bw.flush();
	}

}
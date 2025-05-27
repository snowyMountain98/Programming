import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int year = 0;
		int[][] icbrg, newIcbrg;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		icbrg = new int[N][M];
		newIcbrg = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				icbrg[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 빙산이 두 덩어리 이상으로 분리되거나 다 녹을 때까지 반복 */
		do {
			/* 현재 빙산 상태를 복사해서 새로운 배열에 저장 */
			for (int i = 1; i < N - 1; i++)
				newIcbrg[i] = Arrays.copyOf(icbrg[i], M);

			/* 빙산이 녹는 과정 시뮬레이션 */
			for (int y = 1; y < N - 1; y++) {
				for (int x = 1; x < M - 1; x++) {
					if (icbrg[y][x] == 0)
						continue;

					/* 인접한 바다의 수만큼 높이를 감소 */
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];

						if (icbrg[ny][nx] == 0)
							newIcbrg[y][x]--;
					}

					/* 음수가 되지 않도록 0으로 보정 */
					newIcbrg[y][x] = newIcbrg[y][x] < 0 ? 0 : newIcbrg[y][x];
				}
			}

			/* 빙산 덩어리 개수 계산 */
			int num = numOfIcbrg(newIcbrg);

			/* 1년 경과 */
			year++;

			/* 모두 녹았을 경우 */
			if (num == 0) {
				year = 0;
				break;
			}
			/* 두 덩어리 이상으로 분리되면 중단 */
			else if (num > 1)
				break;

			/* 상태 갱신 */
			for (int i = 1; i < N - 1; i++)
				icbrg[i] = Arrays.copyOf(newIcbrg[i], M);
		} while (true);

		bw.write(year + "\n");
		bw.flush();
	}

	/**
	 * 빙산의 덩어리 개수 (BFS 탐색)
	 */
	public static int numOfIcbrg(int[][] icbrg) {
		boolean[][] vstd = new boolean[N][M];
		int num = 0;
		Queue<int[]> Q = new LinkedList<>();

		for (int y = 1; y < N - 1; y++) {
			for (int x = 1; x < M - 1; x++) {
				if (icbrg[y][x] == 0 || vstd[y][x])
					continue;

				/* 새로운 덩어리 발견 */
				vstd[y][x] = true;
				num++;
				Q.add(new int[] { x, y });

				/* BFS 탐색 */
				while (!Q.isEmpty()) {
					int[] now = Q.poll();

					for (int d = 0; d < 4; d++) {
						int nx = now[0] + dx[d];
						int ny = now[1] + dy[d];

						/* 바다이거나 이미 방문했으면 무시 */
						if (icbrg[ny][nx] == 0 || vstd[ny][nx])
							continue;

						vstd[ny][nx] = true;
						Q.add(new int[] { nx, ny });
					}
				}
			}
		}

		return num;
	}

}
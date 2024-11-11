import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, wall = 0, safeArea, max = Integer.MIN_VALUE;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static Queue<int[]> Q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 벽을 설치하고 최대 안전 구역 크기 계산 */
		buildWall();

		bw.write(max + "\n");
		bw.flush();
	}

	/**************************************************
	 * 벽을 세우는 메서드 (재귀적으로 호출)
	 **************************************************/
	public static void buildWall() {
		/* 벽이 3개 설치된 경우 바이러스 전파 후 안전 구역 크기 계산 */
		if (wall == 3) {
			virus();
			return;
		}

		/* 모든 좌표를 순회하며 벽을 세울 수 있는 곳에 설치 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wall++;
					buildWall();
					map[i][j] = 0;
					wall--;
				}
			}
		}
	}

	/**************************************************
	 * 바이러스를 전파시키는 메서드
	 **************************************************/
	public static void virus() {
		int nx, ny, safeArea = 0;
		int copyMap[][] = new int[N][M];

		/* 맵의 상태를 복사 */
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		/* 바이러스가 있는 위치를 큐에 추가 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (map[i][j] == 2)
					Q.add(new int[] { j, i });
		}

		/* BFS를 이용해 바이러스 전파 */
		while (!Q.isEmpty()) {
			int[] crnt = Q.poll();

			for (int i = 0; i < 4; i++) {
				nx = crnt[0] + dx[i];
				ny = crnt[1] + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (copyMap[ny][nx] != 0)
						continue;

					copyMap[ny][nx] = 2;
					Q.add(new int[] { nx, ny });
				}
			}
		}

		/* 안전 구역(빈 공간)의 개수 계산 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (copyMap[i][j] == 0)
					safeArea++;
		}

		max = Math.max(max, safeArea);
	}

}
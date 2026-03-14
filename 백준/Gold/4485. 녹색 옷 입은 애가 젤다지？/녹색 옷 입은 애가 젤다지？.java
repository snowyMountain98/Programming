import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
	static int[][] cave;
	static PriorityQueue<Rupee> pQ;

	/* 위치와 현재까지의 비용 */
	static class Rupee implements Comparable<Rupee> {
		int x, y, wght;

		public Rupee(int x, int y, int wght) {
			this.x = x;
			this.y = y;
			this.wght = wght;
		}

		/* 우선순위 큐에서 비용이 작은 것이 먼저 나오도록 설정 */
		@Override
		public int compareTo(Rupee o) {
			return Integer.compare(this.wght, o.wght);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int num = 0;

		while (true) {
			num++;
			N = Integer.parseInt(br.readLine());

			/* N이 0이면 종료 */
			if (N == 0)
				break;

			cave = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++)
					cave[i][j] = Integer.parseInt(st.nextToken());
			}

			/* 시작 위치 (0,0) 을 우선순위 큐에 삽입 */
			pQ = new PriorityQueue<>();
			pQ.add(new Rupee(0, 0, cave[0][0]));

			bw.write("Problem " + num + ": " + bfs() + "\n");
		}

		bw.flush();
	}

	/**
	 * 다익스트라 알고리즘
	 */
	public static int bfs() {
		/* 각 위치까지 도달하는 최소 비용 저장 배열 */
		int[][] cost = new int[N][N];

		/* 초기값을 무한대로 설정 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				cost[i][j] = Integer.MAX_VALUE;
		}

		/* 초기값을 무한대로 설정 */
		cost[0][0] = cave[0][0];

		/* 우선순위 큐가 빌 때까지 반복 */
		while (!pQ.isEmpty()) {
			/* 현재 비용이 가장 작은 위치 선택 */
			Rupee now = pQ.poll();

			/* 이미 더 작은 비용으로 방문한 경우 무시 */
			if (now.wght > cost[now.x][now.y])
				continue;

			/* 4방향 탐색 */
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				/* 맵 범위 밖이면 무시 */
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				/* 새로운 비용 계산 */
				int newCost = cost[now.x][now.y] + cave[nx][ny];

				/* 더 작은 비용으로 갈 수 있다면 갱신 */
				if (newCost < cost[nx][ny]) {
					cost[nx][ny] = newCost;
					/* 우선순위 큐에 삽입 */
					pQ.add(new Rupee(nx, ny, newCost));
				}
			}
		}

		/* 도착점까지의 최소 비용 반환 */
		return cost[N - 1][N - 1];
	}
}
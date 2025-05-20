import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;

	/* 상태 클래스: 빨간 구슬, 파란 구슬의 위치와 현재 깊이(depth)를 저장 */
	static class State {
		int rx, ry, bx, by, depth;

		State(int rx, int ry, int bx, int by, int depth) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.depth = depth;
		}
	}

	/* 구슬 클래스: 좌표(x, y)와 이동 횟수(cnt)를 저장 */
	static class Marble {
		int x, y, cnt;

		Marble(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[][][][] vstd;
		int N, M, rx = 0, ry = 0, bx = 0, by = 0;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
		Queue<State> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		vstd = new boolean[N][M][N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);

				if (board[i][j] == 'R') {
					rx = j;
					ry = i;
				} else if (board[i][j] == 'B') {
					bx = j;
					by = i;
				}
			}
		}

		vstd[ry][rx][by][bx] = true;
		Q.add(new State(rx, ry, bx, by, 0));

		/* BFS */
		while (!Q.isEmpty()) {
			State now = Q.poll();

			/* 10번 초과 시 종료 */
			if (now.depth >= 10)
				break;

			for (int dir = 0; dir < 4; dir++) {
				/* 각각의 방향으로 구슬을 이동 */
				Marble R = move(now.rx, now.ry, dx[dir], dy[dir]);
				Marble B = move(now.bx, now.by, dx[dir], dy[dir]);

				/* 파란 구슬이 구멍에 빠졌으면 해당 경우는 무시 */
				if (board[B.y][B.x] == 'O')
					continue;

				/* 빨간 구슬이 구멍에 빠지면 성공 */
				if (board[R.y][R.x] == 'O') {
					bw.write(now.depth + 1 + "\n");
					bw.flush();
					System.exit(0);
				}

				/* 두 구슬의 위치가 겹치는 경우, 이동 횟수가 더 많은 쪽을 한 칸 뒤로 물림 */
				if (R.x == B.x && R.y == B.y) {
					if (R.cnt < B.cnt) {
						B.x -= dx[dir];
						B.y -= dy[dir];
					} else {
						R.x -= dx[dir];
						R.y -= dy[dir];
					}
				}

				/* 아직 방문하지 않은 상태이면 큐에 추가 */
				if (!vstd[R.y][R.x][B.y][B.x]) {
					vstd[R.y][R.x][B.y][B.x] = true;
					Q.add(new State(R.x, R.y, B.x, B.y, now.depth + 1));
				}
			}
		}

		/********************************************************************************
		 * #######     #######     #######     #######     #######     #######
		 * #...RB#     #RB...#     #.B...#     #....B#     #....B#     #B....#
		 * #.#####     #.#####     #.#####     #.#####     #.#####     #.#####
		 * #.....#  →  #.....#  →  #R....#  →  #....R#  →  #.....#  →  #.....#
		 * #####.#     #####.#     #####.#     #####.#     #####.#     #####.#
		 * #O....#     #O....#     #O....#     #O....#     #O...R#     #O....#
		 * #######     #######     #######     #######     #######     #######
		 ********************************************************************************/

		bw.write("-1\n");
		bw.flush();
	}

	/* 주어진 방향으로 구슬을 이동 */
	public static Marble move(int x, int y, int dx, int dy) {
		int cnt = 0;

		while (true) {
			int nx = x + dx;
			int ny = y + dy;

			/* 벽이거나, 현재 위치가 구멍이라면 멈춤 */
			if (board[ny][nx] == '#' || board[y][x] == 'O')
				break;

			x = nx;
			y = ny;
			cnt++;
		}

		return new Marble(x, y, cnt);
	}

}
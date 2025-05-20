import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] board;

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 최대 5번 이동 가능한 모든 경우 탐색 */
		dfs(board, 0);

		bw.write(max + "\n");
		bw.flush();
	}

	/**************************************************
	 * 깊이 우선 탐색
	 **************************************************/
	public static void dfs(int[][] brd, int depth) {
		if (depth == 5) {
			/* 현재 상태에서 가장 큰 블록값을 max와 비교 */
			max = Math.max(findMax(brd), max);
			return;
		}

		/* 4방향(우, 하, 좌, 상)으로 이동 시도 */
		for (int d = 0; d < 4; d++) {
			int[][] newBrd = move(d, brd);
			dfs(newBrd, depth + 1);
		}
	}

	/**************************************************
	 * 보드를 주어진 방향(dir)으로 이동
	 **************************************************/
	public static int[][] move(int dir, int[][] brd) {
		boolean[][] merged = new boolean[N][N];
		int[][] newBrd = new int[N][N];

		/* 방향별로 순회 순서를 다르게 설정 */
		for (int i = 0; i < N; i++)
			newBrd[i] = brd[i].clone();

		switch (dir) {
		case 0: // 우
			for (int x = N - 1; x >= 0; x--) {
				for (int y = 0; y < N; y++)
					moveOneBlock(x, y, dir, newBrd, merged);
			}
			break;
		case 1: // 하
			for (int y = N - 1; y >= 0; y--) {
				for (int x = 0; x < N; x++)
					moveOneBlock(x, y, dir, newBrd, merged);
			}
			break;
		case 2: // 좌
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++)
					moveOneBlock(x, y, dir, newBrd, merged);
			}
			break;
		case 3: // 상
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++)
					moveOneBlock(x, y, dir, newBrd, merged);
			}
			break;
		}

		return newBrd;
	}

	/**************************************************
	 * 하나의 블록을 주어진 방향으로 이동 및 병합
	 **************************************************/
	public static void moveOneBlock(int x, int y, int dir, int[][] brd, boolean[][] merged) {
		/* 이동할 블록이 없으면 건너뜀 */
		if (brd[y][x] == 0)
			return;

		while (true) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			/* 경계 밖이거나 이미 병합된 블록이면 이동 종료 */
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || merged[ny][nx])
				break;

			/* 이동하려는 칸이 비어있으면 블록을 이동 */
			if (brd[ny][nx] == 0) {
				brd[ny][nx] = brd[y][x];
				brd[y][x] = 0;
				x = nx;
				y = ny;
				continue;
			}

			/* 이동하려는 칸에 같은 숫자가 있다면 병합 */
			if (brd[ny][nx] == brd[y][x]) {
				brd[ny][nx] = brd[y][x] * 2;
				brd[y][x] = 0;
				merged[ny][nx] = true;	// 병합된 위치는 다시 병합되지 않도록 표시
				break;
			}

			/* 다른 숫자가 있으면 이동 종료 */
			break;
		}
	}

	/**************************************************
	 * 현재 보드에서 가장 큰 블록값 찾기
	 **************************************************/
	public static int findMax(int[][] brd) {
		int mx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				mx = Math.max(mx, brd[i][j]);
		}

		return mx;
	}

}
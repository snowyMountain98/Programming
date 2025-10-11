import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt;
	static int[][] house;
	static int[] dx = { 1, 0, 1 }, dy = { 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		house = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++)
				house[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 파이프의 시작 위치는 (1,1)-(1,2), 방향은 가로(0) */
		dfs(2, 1, 0);

		bw.write(cnt + "\n");
		bw.flush();
	}

	/**
	 * 파이프 옮기기 DFS
	 * 
	 * @param x	현재 파이프의 끝점 x 좌표
	 * @param y	현재 파이프의 끝점 y 좌표
	 * @param d	현재 파이프 방향 (0: 가로, 1: 세로, 2: 대각선)
	 */
	public static void dfs(int x, int y, int d) {
		/* 목적지 도달 시 경우의 수 증가 */
		if (x == N && y == N) {
			cnt++;
			return;
		}

		/* 다음 가능한 이동 방향 3가지 검사 */
		for (int i = 0; i < 3; i++) {
			/* (가로 → 세로) 또는 (세로 → 가로) 이동 금지 */
			if ((d == 0 && i == 1) || (d == 1 && i == 0))
				continue;

			int nx = x + dx[i];
			int ny = y + dy[i];

			/* 범위를 벗어나거나 벽일 경우 스킵 */
			if (nx > N || ny > N || house[ny][nx] == 1)
				continue;

			/* 대각선 이동 시 추가적으로 확인해야 할 두 칸이 벽이면 스킵 */
			if (i == 2 && (house[y][nx] == 1 || house[ny][x] == 1))
				continue;

			/* 다음 위치로 재귀 호출 */
			dfs(nx, ny, i);
		}
	}
}
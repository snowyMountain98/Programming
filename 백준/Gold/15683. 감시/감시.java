import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int min = 100;
	static int n, m;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][][] directions = { {},
			{ { 0 }, { 1 }, { 2 }, { 3 } },				// 1번: 한 방향
			{ { 0, 2 }, { 1, 3 } },					// 2번: 양 방향 (동-서, 남-북)
			{ { 0, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 } },		// 3번: 직각 두 방향
			{ { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 3 } },	// 4번: 세 방향
			{ { 0, 1, 2, 3 } } };					// 5번: 네 방향
	static List<CCTV> cctv = new ArrayList<>();

	static class CCTV {
		int x, y, type;

		CCTV(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		char[][] office;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		office = new char[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				office[i][j] = st.nextToken().charAt(0);

				/* CCTV인 경우 리스트에 저장 (0: 빈칸, 6: 벽 제외) */
				if (office[i][j] != '0' && office[i][j] != '6')
					cctv.add(new CCTV(j, i, office[i][j] - '0'));
			}
		}

		/* DFS */
		dfs(0, office);

		bw.write(min + "\n");
		bw.flush();
	}

	/**
	 * DFS로 CCTV의 모든 방향 조합 탐색
	 */
	public static void dfs(int depth, char[][] office) {
		char[][] copy = new char[n][m];

		/* 모든 CCTV 배치 완료 시 사각지대 계산 */
		if (depth == cctv.size()) {
			int blindSpot = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++)
					if (office[i][j] == '0')
						blindSpot++;
			}

			min = Math.min(min, blindSpot);
			return;
		}

		/* 현재 CCTV에 가능한 모든 방향 조합 적용 */
		for (int[] dirSet : directions[cctv.get(depth).type]) {
			/* 맵 복사 (deep copy) */
			for (int i = 0; i < n; i++)
				copy[i] = Arrays.copyOf(office[i], m);

			/* 각 방향으로 감시 */
			for (int dir : dirSet)
				watch(copy, cctv.get(depth).x, cctv.get(depth).y, dir);

			/* 다음 CCTV로 진행 */
			dfs(depth + 1, copy);
		}
	}

	/**
	 * 지정된 방향(dir)으로 감시 영역 표시
	 */
	public static void watch(char[][] office, int x, int y, int d) {
		int nx, ny;

		while (true) {
			nx = x + dx[d];
			ny = y + dy[d];

			/* 맵 경계 벗어나거나 벽이면 종료 */
			if (nx < 0 || nx >= m || ny < 0 || ny >= n || office[ny][nx] == '6')
				break;

			/* 빈 공간이면 감시 영역 표시 */
			if (office[ny][nx] == '0')
				office[ny][nx] = '#';

			/* 다음 위치로 이동 */
			x = nx;
			y = ny;
		}
	}

}

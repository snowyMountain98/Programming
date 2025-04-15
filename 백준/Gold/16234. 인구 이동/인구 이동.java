import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] vstd;
	static int N, L, R, sum;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] A;
	static List<int[]> union;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int day = 0;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			boolean moved = false;
			vstd = new boolean[N][N];

			/* 모든 칸에 대해 BFS 수행 */
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					if (!vstd[i][j])	// 방문하지 않은 곳만 탐색
						if (BFS(j, i))	// 인구 이동이 발생했으면
							moved = true;
			}

			if (!moved)	// 인구 이동이 더 이상 발생하지 않으면 종료
				break;

			day++;	// 인구 이동 발생 → 날짜 증가
		}

		/**************************************************
		 * Day 0:                    Day 1:                   
		 * ┏━━━━┳━━━━┳━━━━┳━━━━┓   ┏━━━━┳━━━━┯━━━━┳━━━━┓  
		 * ┃ 10 ┃100 ┃ 20 ┃ 90 ┃   ┃ 10 ┃100 │ 50 ┃ 50 ┃  
		 * ┣━━━━╇━━━━╃────╀────┨   ┠────╂────╆━━━━╋━━━━┫  
		 * ┃ 80 │100 │ 60 │ 70 ┃   ┃ 50 ┃ 50 ┃ 50 ┃ 50 ┃  
		 * ┠────┾━━━━┽────┼────┨ → ┣━━━━╋━━━━╋━━━━╋━━━━┫ →
		 * ┃ 70 │ 20 │ 30 │ 40 ┃   ┃ 50 ┃ 50 ┃ 50 ┃ 50 ┃  
		 * ┠────┾━━━━╈━━━━╅────┨   ┣━━━━╋━━━━╃────╄━━━━┫  
		 * ┃ 50 │ 20 ┃100 ┃ 10 ┃   ┃ 50 ┃ 50 │100 │ 50 ┃  
		 * ┗━━━━┷━━━━┻━━━━┻━━━━┛   ┗━━━━┻━━━━┷━━━━┷━━━━┛
		 * Day 2:                  Day 3:
		 * ┏━━━━┯━━━━┳━━━━┯━━━━┓   ┏━━━━┳━━━━┳━━━━┳━━━━┓
		 * ┃ 30 │ 66 ┃ 66 │ 50 ┃   ┃ 48 ┃ 48 ┃ 54 ┃ 54 ┃
		 * ┣━━━━┿━━━━╃────╆━━━━┫   ┣━━━━╋━━━━╋━━━━╋━━━━┫
		 * ┃ 30 │ 66 │ 50 ┃ 50 ┃   ┃ 54 ┃ 54 ┃ 54 ┃ 50 ┃
		 * ┠────╁────┼────╄━━━━┫ → ┣━━━━╋━━━━╋━━━━╋━━━━┫
		 * ┃ 50 ┃ 50 │ 62 │ 50 ┃   ┃ 54 ┃ 54 ┃ 54 ┃ 54 ┃
		 * ┣━━━━╃────╆━━━━╅────┨   ┣━━━━╋━━━━╋━━━━╋━━━━┫
		 * ┃ 50 │ 62 ┃ 62 ┃ 62 ┃   ┃ 54 ┃ 54 ┃ 62 ┃ 54 ┃
		 * ┗━━━━┷━━━━┻━━━━┻━━━━┛   ┗━━━━┻━━━━┻━━━━┻━━━━┛ 
		 **************************************************/

		bw.write(day + "\n");
		bw.flush();
	}

	/**************************************************
	 * BFS를 통한 연합 찾기 및 인구 이동 체크
	 **************************************************/
	public static boolean BFS(int x, int y) {
		Queue<int[]> Q = new LinkedList<>();
		union = new ArrayList<>();

		/* 시작 위치 초기화 */
		Q.add(new int[] { x, y });
		union.add(new int[] { x, y });
		vstd[y][x] = true;
		sum = A[y][x];

		/* BFS 시작 */
		while (!Q.isEmpty()) {
			int[] now = Q.poll();
			int cx = now[0];
			int cy = now[1];

			/* 4방향 탐색 */
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				if (vstd[ny][nx])
					continue;

				/* 인구 차이 계산 */
				int diff = Math.abs(A[cy][cx] - A[ny][nx]);

				/* 인구 차이가 조건에 맞으면 연합에 추가 */
				if (L <= diff && diff <= R) {
					Q.add(new int[] { nx, ny });
					union.add(new int[] { nx, ny });
					vstd[ny][nx] = true;
					sum += A[ny][nx];
				}
			}
		}

		/* 연합이 2개 이상이면 인구 이동 수행 */
		if (union.size() > 1) {
			ppltnMvmnt();	// 연합 내 인구 이동
			return true;		// 인구 이동 발생
		} else
			return false;		// 인구 이동 없음
	}

	/**************************************************
	 * 연합 내 인구 이동
	 **************************************************/
	public static void ppltnMvmnt() {
		int avg;

		avg = sum / union.size();	// 평균 인구 계산

		/* 연합 내 모든 칸에 평균값으로 인구 재분배 */
		for (int[] a : union)
			A[a[1]][a[0]] = avg;
	}

}
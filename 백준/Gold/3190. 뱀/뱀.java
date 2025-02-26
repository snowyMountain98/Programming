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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int[][] board;
	static Queue<int[]> snake = new LinkedList<>();
	static String[] C = new String[10001];

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		int K, L, X;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		board = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}

		L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			C[X] = st.nextToken();
		}

		snake.offer(new int[] { 1, 1 });
		dfs(1, 1, 0, 0);
	}

	public static void dfs(int x, int y, int sec, int d) throws IOException {
		int nx, ny;

		/* 현재 시간(sec)에 따라 방향 변환 */
		if (sec < C.length && "L".equals(C[sec]))
			d = d - 1 < 0 ? 3 : d - 1;	// 왼쪽으로 회전
		else if (sec < C.length && "D".equals(C[sec]))
			d = d + 1 > 3 ? 0 : d + 1;	// 오른쪽으로 회전

		/* 다음 위치 계산 */
		nx = x + dx[d];
		ny = y + dy[d];

		/* 보드 밖으로 나가면 게임 종료 */
		if (nx < 1 || nx > N || ny < 1 || ny > N) {
			bw.write(sec + 1 + "\n");
			bw.flush();
			System.exit(0);
		}

		/* 뱀이 자기 자신과 부딪히면 게임 종료 */
		for (int[] arr : snake) {
			if (Arrays.equals(arr, new int[] { ny, nx })) {
				bw.write(sec + 1 + "\n");
				bw.flush();
				System.exit(0);
			}
		}

		/* 다음 위치에 사과가 있으면 */
		if (board[ny][nx] == 1) {
			snake.offer(new int[] { ny, nx });	// 뱀의 몸 길이 증가
			board[ny][nx] = 0;					// 사과 제거
			dfs(nx, ny, sec + 1, d);
		}
		/* 다음 위치에 사과가 없으면 */
		else {
			snake.offer(new int[] { ny, nx });	// 뱀이 이동
			snake.poll();						// 꼬리를 제거하여 길이를 유지
			dfs(nx, ny, sec + 1, d);
		}

	}

}
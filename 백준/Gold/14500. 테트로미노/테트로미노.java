import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max, sum;
	static int[][] paper;
	static int[] dx = { 1, 0, -1 }, dy = { 0, 1, 0 }; // 이동 방향(우, 하, 좌)을 나타내는 배열
	static boolean[][] vstd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		paper = new int[N][M];
		vstd = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum = paper[i][j];
				vstd[i][j] = true;
				dfs(j, i, 1);
				vstd[i][j] = false;
			}
		}

		bw.write(max + "\n");
		bw.flush();
	}

	public static void dfs(int x, int y, int depth) {
		int nx, ny;

		if (depth == 4) {
			if (max < sum)
				max = sum;

			return;
		}

		for (int i = 0; i < 3; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
				if (vstd[ny][nx])
					continue;

				sum += paper[ny][nx];
				vstd[ny][nx] = true;
				dfs(nx, ny, depth + 1);
				sum -= paper[ny][nx];
				vstd[ny][nx] = false;

				/* "ㅗ" 모양을 처리하기 위해 케이스 추가 */
				if (depth == 2) {
					sum += paper[ny][nx];
					vstd[ny][nx] = true;
					dfs(x, y, depth + 1); // 현재 위치에서 추가 탐색
					sum -= paper[ny][nx];
					vstd[ny][nx] = false;
				}
			}
		}
	}

}
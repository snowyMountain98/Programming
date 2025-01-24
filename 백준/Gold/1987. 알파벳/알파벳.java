import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] alphabet = new boolean[26];
	static char[][] board;
	static int R, C, max;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();

			for (int j = 0; j < C; j++)
				board[i][j] = str.charAt(j);
		}

		alphabet[board[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		bw.write(max + "\n");
		bw.flush();
	}

	public static void dfs(int x, int y, int cnt) {
		int nx, ny;

		if (max < cnt)
			max = cnt;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
				if (alphabet[board[ny][nx] - 'A'])
					continue;

				alphabet[board[ny][nx] - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				alphabet[board[ny][nx] - 'A'] = false;
			}
		}
	}

}
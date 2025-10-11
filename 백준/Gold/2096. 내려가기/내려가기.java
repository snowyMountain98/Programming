import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
		int[][] board, max, min;

		N = Integer.parseInt(br.readLine());

		board = new int[N][3];
		max = new int[N][3];
		min = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			max[0][i] = board[0][i];
			min[0][i] = board[0][i];
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				max[i][j] = max[i - 1][j] + board[i][j];
				min[i][j] = min[i - 1][j] + board[i][j];

				if (j >= 1) {
					max[i][j] = Math.max(max[i - 1][j - 1] + board[i][j], max[i][j]);
					min[i][j] = Math.min(min[i - 1][j - 1] + board[i][j], min[i][j]);
				}

				if (j < 2) {
					max[i][j] = Math.max(max[i - 1][j + 1] + board[i][j], max[i][j]);
					min[i][j] = Math.min(min[i - 1][j + 1] + board[i][j], min[i][j]);
				}
			}
		}

		for (int i = 0; i < 3; i++)
			mx = Math.max(mx, max[N - 1][i]);

		for (int i = 0; i < 3; i++)
			mn = Math.min(mn, min[N - 1][i]);

		bw.write(mx + " " + mn + "\n");
		bw.flush();
	}

}
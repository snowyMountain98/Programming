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
		int N, M, x1, y1, x2, y2;
		int[][] table, sum;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		table = new int[N + 1][N + 1];
		sum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] + table[i][j] - sum[i - 1][j - 1];
			}
		}
		
		/**************************************************
		 * ┌────┬────┬────┬────┐
		 * │  1 │  3 │  6 │ 10 │
		 * ├────╆━━━━╈━━━━╈━━━━┪
		 * │  3 ┃  8 ┃ 15 ┃ 24 ┃
		 * ├────╊━━━━╋━━━━╋━━━━┫
		 * │  6 ┃ 15 ┃ 27 ┃ 42 ┃
		 * ├────╄━━━━╇━━━━╇━━━━┩
		 * │ 10 │ 24 │ 42 │ 64 │
		 * └────┴────┴────┴────┘
		 **************************************************/

		while (M > 0) {
			st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			bw.write(sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1] + "\n");

			M--;
		}
		
		bw.flush();
	}

}
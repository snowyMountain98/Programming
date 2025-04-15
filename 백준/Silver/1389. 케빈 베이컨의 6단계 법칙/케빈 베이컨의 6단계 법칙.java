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
		int N, M, min;
		int[] kvnbc;
		int[][] frnd;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		kvnbc = new int[N + 1];
		frnd = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			frnd[A][B] = 1;
			frnd[B][A] = 1;
		}

		/**************************************************
		 * [0, 0, 1, 1, 0]
		 * [0, 0, 1, 0, 0]
		 * [1, 1, 0, 1, 0]
		 * [1, 0, 1, 0, 1]
		 * [0, 0, 0, 1, 0]
		 **************************************************/

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;

					if (frnd[i][k] != 0 && frnd[k][j] != 0)
						frnd[i][j] = frnd[i][j] == 0 ? frnd[i][k] + frnd[k][j]
								: Math.min(frnd[i][j], frnd[i][k] + frnd[k][j]);
				}
			}
		}

		/**************************************************
		 * [0, 2, 1, 1, 2]
		 * [2, 0, 1, 2, 3]
		 * [1, 1, 0, 1, 2]
		 * [1, 2, 1, 0, 1]
		 * [2, 3, 2, 1, 0]
		 **************************************************/

		min = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				kvnbc[i] += frnd[i][j];

			if (kvnbc[min] > kvnbc[i])
				min = i;
		}

		bw.write(min + "\n");
		bw.flush();
	}

}
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
		int N, K;
		int[][] C;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		K = Math.min(K, N - K);

		C = new int[N + 1][N + 1];
		
		/**************************************************
		 * nCr = (n-1)C(r-1) + (n-1)Cr
		 **************************************************/

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j || j == 0)
					C[i][j] = 1;
				else
					C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % 10007;
			}
		}

		bw.write(C[N][K] + "\n");
		bw.flush();
	}

}
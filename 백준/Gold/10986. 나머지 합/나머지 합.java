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
		long[] A, S, rmn; // remainder
		long answer = 0;
		int N, M;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		/**************************************************
		 * 구간의 합(i, j) :
		 * A[i] + … + A[j] = S[j] - S[i - 1]
		 * 
		 * 합이 M으로 나누어 떨어지는 (i, j) :
		 * (S[j] - S[i - 1]) % M = 0
		 * ⇒ S[j] % M = S[i - 1] % M
		 **************************************************/

		A = new long[N];
		S = new long[N];
		rmn = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			S[i] = i == 0 ? A[i] : S[i - 1] + A[i];
			rmn[(int) (S[i] % M)]++;
		}

		/**************************************************
		 * A	: [1, 2, 3, 1, 2]
		 * S	: [1, 3, 6, 7, 9]
		 * rmn	: [3, 2, 0]
		 **************************************************/

		answer += rmn[0];

		/**************************************************
		 *       n(n−1)(n−2)⋯(n−r+1)
		 * nCr = ───────────────────
		 *               r!
		 **************************************************/
		for (int i = 0; i < M; i++) {
			if (rmn[i] > 1)
				answer += rmn[i] * (rmn[i] - 1) / 2;
		}

		bw.write(answer + "\n");
		bw.flush();
	}

}
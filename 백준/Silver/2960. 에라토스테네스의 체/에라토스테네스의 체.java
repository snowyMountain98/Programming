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
		boolean[] isPrime;
		int N, K, cnt = 0;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		isPrime = new boolean[N + 1];

		for (int i = 2; i <= N; i++)
			isPrime[i] = true;

		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				if (!isPrime[j])
					continue;

				isPrime[j] = false;
				cnt++;

				if (cnt == K) {
					bw.write(j + "\n");
					bw.flush();
					return;
				}
			}
		}
		
		/******************************
		 *  cnt │  j
		 * ─────┼────
		 *   1  │  2
		 *   2  │  4
		 *   3  │  6
		 *   4  │  8
		 *   5  │ 10
		 *   6  │ 12
		 *   7  │ 14
		 *   8  │  3
		 *   9  │  9
		 *  10  │ 15
		 *  11  │  5
		 *  12  │  7
		 ******************************/
	}

}
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
		int T, x, y, d;
		long n;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			d = y - x;

			n = (int) Math.sqrt(d);

			if (n * n == d)
				bw.write(n * 2 - 1 + "\n");
			if (n * n < d && d <= n * (n + 1))
				bw.write(n * 2 + "\n");
			else if (n * (n + 1) < d && d <= (n + 1) * (n + 1))
				bw.write(n * 2 + 1 + "\n");

			bw.flush();
			T--;
		}

		/************************************************** 
		 *     │          move           │  d │
		 * ────┼─────────────────────────┼────┼───────
		 *   1 │            1            │  1 │ 1 * 1
		 *   2 │           1 1           │  2 │ 1 * 2
		 *   3 │          1 2 1          │  4 │ 2 * 2
		 *   4 │         1 2 2 1         │  6 │ 2 * 3
		 *   5 │        1 2 3 2 1        │  9 │ 3 * 3
		 *   6 │       1 2 3 3 2 1       │ 12 │ 3 * 4
		 *   7 │      1 2 3 4 3 2 1      │ 16 │ 4 * 4
		 *   8 │     1 2 3 4 4 3 2 1     │ 20 │ 4 * 5
		 *   9 │    1 2 3 4 5 4 3 2 1    │ 25 │ 5 * 5
		 *  10 │   1 2 3 4 5 5 4 3 2 1   │ 30 │ 5 * 6
		 *  11 │  1 2 3 4 5 6 5 4 3 2 1  │ 36 │ 6 * 6
		 *  12 │ 1 2 3 4 5 6 6 5 4 3 2 1 │ 42 │ 6 * 7 
		 **************************************************/
	}

}
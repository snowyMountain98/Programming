import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long k, low, hgh, mid;

		N = Long.parseLong(br.readLine());
		k = Long.parseLong(br.readLine());

		low = 1;
		hgh = N * N;

		while (low <= hgh) {
			mid = (low + hgh) / 2;

			if (B(mid) < k)
				low = mid + 1;
			else
				hgh = mid - 1;
		}

		bw.write(low + "\n");
		bw.flush();
	}
	
	/**************************************************
	 *    ┃ 1 ┃ 2 ┃ 3 ┃ ≤ 7
	 * ━━━╋━━━╇━━━╇━━━╇━━━━━
	 *  1 ┃ 1 │ 2 │ 3 │  3
	 * ━━━╉───┼───┼───┼─────
	 *  2 ┃ 2 │ 4 │ 6 │  3
	 * ━━━╉───┼───┼───┼─────
	 *  3 ┃ 3 │ 6 │ 9 │  2
	 **************************************************/

	public static long B(long mid) {
		long cnt = 0;

		for (int i = 1; i <= N; i++)
			cnt += Math.min(mid / i, N);

		return cnt;
	}
}
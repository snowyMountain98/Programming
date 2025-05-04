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
		int N, bdgt, low = 0, hgh = 1, mid = 0;
		int[] bdgtRqst;

		N = Integer.parseInt(br.readLine());

		bdgtRqst = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			bdgtRqst[i] = Integer.parseInt(st.nextToken());
			hgh = Math.max(hgh, bdgtRqst[i]);
		}

		bdgt = Integer.parseInt(br.readLine());

		while (low <= hgh) {
			mid = (low + hgh) / 2;

			int sum = 0;

			for (int i = 0; i < N; i++)
				sum += bdgtRqst[i] < mid ? bdgtRqst[i] : mid;

			if (sum > bdgt)
				hgh = mid - 1;
			else
				low = mid + 1;
		}

		/**************************************************
		 *  low │ mid │ hgh ┃ sum
		 * ━━━━━┿━━━━━┿━━━━━╋━━━━━
		 *    0 │  75 │ 150 ┃ 300
		 *   76 │ 113 │ 150 ┃ 449
		 *  114 │ 132 │ 150 ┃ 494
		 *  114 │ 122 │ 131 ┃ 474
		 *  123 │ 127 │ 131 ┃ 484
		 *  128 │ 129 │ 131 ┃ 488
		 *  128 │ 128 │ 128 ┃ 486
		 *  128 │ 128 │ 127 ┃
		 **************************************************/

		bw.write(hgh + "\n");
		bw.flush();
	}

}
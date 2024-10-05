import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N, x;

		N = Integer.parseInt(br.readLine());

		while (N > 0) {
			x = Integer.parseInt(br.readLine());

			if (x == 0)
				bw.write((pq.size() == 0 ? 0 : pq.poll()) + "\n");
			else
				pq.add(x);

			bw.flush();

			N--;
		}
		
		/**************************************************
		 *     x     │       pq
		 * ━━━━━━━━━━┿━━━━━━━━━━━━━━━━━━
		 *     0     │ []
		 *  12345678 │ [12345678]
		 *     1     │ [1, 12345678]
		 *     2     │ [1, 12345678, 2]
		 *     0     │ [2, 12345678]
		 *     0     │ [12345678]
		 *     0     │ []
		 *     0     │ []
		 *    32     │ [32]
		 **************************************************/
	}
}
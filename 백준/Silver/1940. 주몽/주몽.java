import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, cnt = 0;
		int[] mtrl;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		mtrl = new int[N];
		for (int i = 0; i < N; i++)
			mtrl[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(mtrl);

		int s = 0, e = N - 1;

		while (s < e) {
			int sum = mtrl[s] + mtrl[e];

			if (sum == M) {
				cnt++;
				s++;
				e--;
			} else if (sum < M)
				s++;
			else
				e--;
		}

		/****************************************
		 *  1	2	3	4	5	7 │ sum │ cnt 
		 * ───────────────────────┼─────┼─────
		 *  ↑                   ↑ │  8  │  0
		 *      ↑               ↑ │  9  │  1
		 *          ↑       ↑     │  8  │  1
		 *              ↑   ↑     │  9  │  2
		 ****************************************/

		bw.write(cnt + "\n");
		bw.flush();
	}

}
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
		int N, max = Integer.MIN_VALUE;
		int[] A, lds;

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		lds = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			lds[i] = 1;

			for (int j = 0; j < i; j++) {
				if (A[i] < A[j])
					lds[i] = Math.max(lds[j] + 1, lds[i]);
			}

			max = Math.max(max, lds[i]);
		}

		/**************************************************
		 * lds : [1, 1, 2, 2, 2, 3]
		 **************************************************/

		bw.write(max + "\n");
		bw.flush();
	}

}
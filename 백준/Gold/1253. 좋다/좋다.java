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
		int N, s, e, cnt = 0;
		long[] A;

		N = Integer.parseInt(br.readLine());

		A = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Long.parseLong(st.nextToken());

		Arrays.sort(A);

		for (int i = 0; i < N; i++) {
			s = 0;
			e = N - 1;

			while (s < e) {
				if (s == i) {
					s++;
					continue;
				} else if (e == i) {
					e--;
					continue;
				}

				if (A[s] + A[e] == A[i]) {
					cnt++;
					break;
				} else if (A[s] + A[e] < A[i])
					s++;
				else
					e--;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

}
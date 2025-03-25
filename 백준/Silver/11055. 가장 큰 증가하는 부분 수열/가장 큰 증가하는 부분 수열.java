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
		int N, max = 0;
		int[] A, dp;

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		dp = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			dp[i] = A[i];

			for (int j = 0; j < i; j++) {
				if (A[j] < A[i])
					dp[i] = Math.max(dp[j] + A[i], dp[i]);
			}

			max = Math.max(max, dp[i]);
		}

		bw.write(max + "\n");
		bw.flush();
	}

}
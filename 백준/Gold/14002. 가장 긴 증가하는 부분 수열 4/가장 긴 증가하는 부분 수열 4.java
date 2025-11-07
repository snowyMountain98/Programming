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
		int A, max, maxIdx;
		int[] arr, dp, prnt, lngIncPrtSqn;

		A = Integer.parseInt(br.readLine());

		arr = new int[A + 1];
		dp = new int[A + 1];
		prnt = new int[A + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= A; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		max = Integer.MIN_VALUE;
		maxIdx = 0;

		for (int i = 1; i <= A; i++) {
			dp[i] = 1;

			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						prnt[i] = j;
					}
				}
			}

			if (max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}

		lngIncPrtSqn = new int[max];
		int idx = max - 1;

		while (idx >= 0) {
			lngIncPrtSqn[idx] = arr[maxIdx];
			maxIdx = prnt[maxIdx];
			idx--;
		}

		bw.write(max + "\n");
		for (int i = 0; i < lngIncPrtSqn.length; i++)
			bw.write(lngIncPrtSqn[i] + " ");
		bw.flush();
	}

}
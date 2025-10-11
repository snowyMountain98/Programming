import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, max = Integer.MIN_VALUE;
	static int[] A, newA;
	static boolean[] vstd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		newA = new int[N];
		vstd = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		dfs(0);

		bw.write(max + "\n");
		bw.flush();
	}

	public static void dfs(int idx) {
		if (idx == N) {
			int sum = 0;

			/* |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]| */
			for (int i = 0; i < N - 1; i++)
				sum += Math.abs(newA[i] - newA[i + 1]);

			if (max < sum)
				max = sum;

			return;
		}

		for (int i = 0; i < N; i++) {
			if (vstd[i])
				continue;

			vstd[i] = true;
			newA[idx] = A[i];
			dfs(idx + 1);
			vstd[i] = false;
		}
	}

}
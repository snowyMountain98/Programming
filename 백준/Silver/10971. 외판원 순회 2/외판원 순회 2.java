import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] vstd;
	static int N, min = Integer.MAX_VALUE;
	static int[][] W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		W = new int[N + 1][N + 1];
		vstd = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			vstd[i] = true;
			dfs(i, i, 1, 0);
			vstd[i] = false;
		}

		bw.write(min + "\n");
		bw.flush();
	}

	public static void dfs(int start, int now, int depth, int cost) {
		if (depth == N) {
			if (W[now][start] == 0)
				return;

			cost += W[now][start];
			min = Math.min(min, cost);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (vstd[i])
				continue;

			if (W[now][i] == 0)
				continue;

			vstd[i] = true;
			dfs(start, i, depth + 1, cost + W[now][i]);
			vstd[i] = false;
		}
	}
}
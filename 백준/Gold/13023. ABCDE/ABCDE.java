import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] frnd;
	static boolean[] vstd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		frnd = new ArrayList[N];
		vstd = new boolean[N];

		for (int i = 0; i < N; i++)
			frnd[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			frnd[a].add(b);
			frnd[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			vstd[i] = true;
			dfs(i, 1);
			vstd[i] = false;
		}

		System.out.println("0");
	}

	public static void dfs(int now, int depth) {
		if (depth == 5) {
			System.out.println("1");
			System.exit(0);
		}

		for (int next : frnd[now]) {
			if (vstd[next])
				continue;

			vstd[next] = true;
			dfs(next, depth + 1);
			vstd[next] = false;
		}
	}
}
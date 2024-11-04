import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] edge;
	static boolean[] vstd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, u, v, cnctdCmpnn = 0;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edge = new ArrayList[N + 1];
		vstd = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			edge[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			edge[u].add(v);
			edge[v].add(u);
		}

		/**************************************************
		 * edge
		 * 1 : [2, 5]
		 * 2 : [1, 5]
		 * 3 : [4]
		 * 4 : [3, 6]
		 * 5 : [2, 1]
		 * 6 : [4]
		 **************************************************/

		for (int i = 1; i <= N; i++) {
			if (!vstd[i]) {
				vstd[i] = true;
				cnctdCmpnn++;

				dfs(i);
			}
		}

		bw.write(cnctdCmpnn + "\n");
		bw.flush();
	}

	public static void dfs(int x) {
		for (int i : edge[x]) {
			if (!vstd[i]) {
				vstd[i] = true;
				dfs(i);
			}
		}
	}

}
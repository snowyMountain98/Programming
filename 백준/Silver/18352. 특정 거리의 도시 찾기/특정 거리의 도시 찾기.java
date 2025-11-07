import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<Integer>[] city;
		boolean flag = false;
		boolean[] vstd;
		int N, M, K, X;
		int[] dstnc;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		city = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			city[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			city[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		vstd = new boolean[N + 1];
		dstnc = new int[N + 1];

		vstd[X] = true;
		Q.add(new int[] { X, 0 });

		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			for (int x : city[now[0]]) {
				if (vstd[x])
					continue;

				dstnc[x] = now[1] + 1;
				vstd[x] = true;
				Q.add(new int[] { x, now[1] + 1 });
			}
		}

		for (int i = 1; i <= N; i++) {
			if (dstnc[i] == K) {
				flag = true;
				bw.write(i + "\n");
			}
		}

		if (!flag)
			bw.write("-1\n");
		bw.flush();
	}

}
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
		int N;
		int[][] build;
		int[] rank;

		N = Integer.parseInt(br.readLine());

		build = new int[N][2];
		rank = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			build[i][0] = Integer.parseInt(st.nextToken());
			build[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;

				if (build[i][0] < build[j][0] && build[i][1] < build[j][1])
					rank[i]++;
			}
		}

		for (int i = 0; i < N; i++)
			bw.write(rank[i] + 1 + " ");
		bw.flush();
	}

}
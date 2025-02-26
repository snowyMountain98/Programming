import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> area = new ArrayList<>();
	static boolean[][] vstd;
	static int M, N, cnt;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };
	static int[][] grpPpr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K, x1, x2, y1, y2;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		grpPpr = new int[M][N];
		vstd = new boolean[M][N];

		while (K > 0) {
			st = new StringTokenizer(br.readLine());

			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++)
					grpPpr[j][i] += 1;
			}

			K--;
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grpPpr[i][j] == 0 && !vstd[i][j]) {
					vstd[i][j] = true;
					cnt = 1;
					dfs(j, i);

					area.add(cnt);
				}
			}
		}

		Collections.sort(area);

		bw.write(area.size() + "\n");
		for (int i = 0; i < area.size(); i++)
			bw.write(area.get(i) + " ");
		bw.write("\n");

		bw.flush();
	}

	public static void dfs(int x, int y) {
		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (grpPpr[ny][nx] == 0 && !vstd[ny][nx]) {
					vstd[ny][nx] = true;
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}

}
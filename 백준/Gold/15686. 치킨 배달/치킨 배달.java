import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt, min = Integer.MAX_VALUE;
	static int[][] dstnc;
	static boolean[] vstd;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chckn = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] city;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());

				if (city[i][j] == 1)
					house.add(new int[] { i, j });
				else if (city[i][j] == 2)
					chckn.add(new int[] { i, j });
			}
		}

		/**************************************************
		 * city :
		 * 0 0 1 0 0
		 * 0 0 2 0 1
		 * 0 1 2 0 0
		 * 0 0 1 0 0
		 * 0 0 0 0 2
		 * 
		 * house : [[1, 3], [2, 5], [3, 2], [4, 3]] 
		 * chckn : [[2, 3], [3, 3], [5, 5]] 
		 **************************************************/

		/* 집과 치킨집 사이의 거리 계산 */
		dstnc = new int[house.size()][chckn.size()];

		for (int i = 0; i < house.size(); i++) {
			for (int j = 0; j < chckn.size(); j++)
				dstnc[i][j] = Math.abs(house.get(i)[0] - chckn.get(j)[0]) + Math.abs(house.get(i)[1] - chckn.get(j)[1]);
		}

		/**************************************************
		 * chcknDstnc :
		 * [1, 2, 6]
		 * [2, 3, 3]
		 * [2, 1, 5]
		 * [2, 1, 3]
		 **************************************************/

		vstd = new boolean[chckn.size()];

		dfs(0);

		bw.write(min + "\n");
		bw.flush();
	}

	/* DFS를 이용하여 M개의 치킨집 선택 */
	public static void dfs(int start) {
		if (cnt == M) {
			min = Math.min(min, getChcknDstnc());
			return;
		}

		for (int i = start; i < chckn.size(); i++) {
			if (vstd[i])
				continue;

			vstd[i] = true;
			cnt += 1;
			dfs(i + 1);
			vstd[i] = false;
			cnt -= 1;
		}
	}

	/* 선택된 치킨집에 대한 총 치킨 거리 계산 */
	public static int getChcknDstnc() {
		int d, chcknDstnc = 0;

		for (int i = 0; i < dstnc.length; i++) {
			d = Integer.MAX_VALUE;

			for (int j = 0; j < dstnc[i].length; j++) {
				if (vstd[j])
					d = Math.min(d, dstnc[i][j]);
			}

			chcknDstnc += d;
		}

		return chcknDstnc;
	}

}
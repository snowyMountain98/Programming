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
		int n, m, a, b, c;
		int[][] bus;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		bus = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			bus[a][b] = bus[a][b] == 0 ? c : Math.min(c, bus[a][b]);
		}

		/**************************************************
		 * 플로이드-워셜 알고리즘
		 **************************************************/
		for (int k = 1; k <= n; k++) { // 경유지
			for (int i = 1; i <= n; i++) { // 출발지
				for (int j = 1; j <= n; j++) { // 도착지
					if (i == j) // 출발지와 도착지가 같으면 패스
						continue;

					/* 경유지를 통해 더 짧은 경로가 존재하면 업데이트 */
					if (bus[i][k] != 0 && bus[k][j] != 0)
						bus[i][j] = bus[i][j] == 0 ? bus[i][k] + bus[k][j] : Math.min(bus[i][j], bus[i][k] + bus[k][j]);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				bw.write(bus[i][j] + " ");
			bw.write("\n");
		}

		bw.flush();
	}

}
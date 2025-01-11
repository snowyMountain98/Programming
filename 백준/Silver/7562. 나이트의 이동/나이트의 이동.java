import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, l;
		int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] start = new int[2], end = new int[2];
		int[][] chessBoard;
		Queue<int[]> Q;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			l = Integer.parseInt(br.readLine());

			chessBoard = new int[l][l];

			/* 시작 위치 */
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());

			/* 목표 위치 */
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			chessBoard[start[0]][start[1]] = 1;
			Q = new LinkedList<>();
			Q.add(start);

			/* BFS 탐색 시작 */
			while (!Q.isEmpty()) {
				int[] now = Q.poll();

				/* 목표 위치에 도달한 경우 */
				if (now[0] == end[0] && now[1] == end[1]) {
					bw.write(chessBoard[end[0]][end[1]] - 1 + "\n");
					break;
				}

				/* 나이트의 8방향 이동 시도 */
				for (int i = 0; i < 8; i++) {
					int nx = now[1] + dx[i];
					int ny = now[0] + dy[i];

					/* 체스판 범위를 벗어나지 않고, 방문하지 않은 경우 */
					if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
						if (chessBoard[ny][nx] > 0)
							continue;

						chessBoard[ny][nx] = chessBoard[now[0]][now[1]] + 1;
						Q.add(new int[] { ny, nx });
					}
				}
			}

			T--;
		}

		bw.flush();
	}

}
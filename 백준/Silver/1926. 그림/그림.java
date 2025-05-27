import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[][] vstd;
		int n, m, max = 0;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
		int[][] paper;
		List<Integer> drawing = new ArrayList<>();
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		paper = new int[n][m];
		vstd = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}

		/* 전체 종이를 순회하면서 BFS로 그림(1로 연결된 영역) 탐색 */
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				/* 방문하지 않았고, 현재 위치가 그림(1)인 경우 */
				if (!vstd[i][j] && paper[i][j] == 1) {
					int area = 0;

					/* 시작점을 큐에 넣고 방문 표시 */
					vstd[i][j] = true;
					Q.add(new int[] { j, i });

					/* BFS 탐색 시작 */
					while (!Q.isEmpty()) {
						int[] now = Q.poll();
						area++;

						/* 4방향으로 탐색 */
						for (int d = 0; d < 4; d++) {
							int nx = now[0] + dx[d];
							int ny = now[1] + dy[d];

							/* 범위를 벗어나는 경우 무시 */
							if (nx < 0 || nx >= m || ny < 0 || ny >= n)
								continue;

							/* 그림이 아니거나 이미 방문한 경우 무시 */
							if (paper[ny][nx] != 1 || vstd[ny][nx])
								continue;

							/* 방문하지 않은 그림이면 큐에 추가하고 방문 표시 */
							vstd[ny][nx] = true;
							Q.add(new int[] { nx, ny });
						}
					}

					/* 하나의 그림 넓이를 리스트에 추가 */
					drawing.add(area);
				}
			}
		}

		for (int i = 0; i < drawing.size(); i++)
			max = Math.max(max, drawing.get(i));

		bw.write(drawing.size() + "\n");
		bw.write(max + "\n");
		bw.flush();
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++)
				maze[i][j] = str.charAt(j) - '0';
		}

		bw.write(bfs() + "\n");
		bw.flush();
	}

	public static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		visited[0][0] = true;
		queue.add(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			if (x == M - 1 && y == N - 1)
				return maze[y][x];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if (!visited[ny][nx] && maze[ny][nx] == 1) {
						visited[ny][nx] = true;
						maze[ny][nx] = maze[y][x] + 1;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}

		return -1;
	}

}
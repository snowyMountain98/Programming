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
		int N, M;
		int[][] maze, candy;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		candy = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				maze[i][j] = Integer.parseInt(st.nextToken());
		}

		candy[0][0] = maze[0][0];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (j > 0)
					candy[i][j] = Math.max(candy[i][j], candy[i][j - 1] + maze[i][j]);

				if (i > 0)
					candy[i][j] = Math.max(candy[i][j], candy[i - 1][j] + maze[i][j]);
			}
		}

		/****************************************
		 * maze:               candy:
		 * ┌───┬───┬───┬───┐   ┌───┬───┬───┬───┐
		 * │ 1 │ 2 │ 3 │ 4 │   │ 1 │ 3 │ 6 │ 10│
		 * ├───┼───┼───┼───┤   ├───┼───┼───┼───┤
		 * │ 0 │ 0 │ 0 │ 5 │   │ 1 │ 3 │ 6 │ 15│
		 * ├───┼───┼───┼───┤   ├───┼───┼───┼───┤
		 * │ 9 │ 8 │ 7 │ 6 │   │ 10│ 18│ 25│ 31│
		 * └───┴───┴───┴───┘   └───┴───┴───┴───┘ 
		 ****************************************/
		bw.write(candy[N - 1][M - 1] + "\n");
		bw.flush();
	}

}
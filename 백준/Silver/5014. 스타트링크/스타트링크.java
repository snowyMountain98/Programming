import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int F, S, G, U, D;
		boolean[] vstd;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());	// 건물의 총 층 수
		S = Integer.parseInt(st.nextToken());	// 현재 있는 층(시작 층)
		G = Integer.parseInt(st.nextToken());	// 도착해야 할 층(목표 층)
		U = Integer.parseInt(st.nextToken());	// 위로 이동할 수 있는 층 수
		D = Integer.parseInt(st.nextToken());	// 아래로 이동할 수 있는 층 수

		vstd = new boolean[F + 1];
		vstd[S] = true;

		/* 큐에 시작점 (S층, 이동 횟수 0) 삽입 */
		Q.add(new int[] { S, 0 });

		/* BFS */
		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			/* 목표 층에 도달했을 경우 */
			if (now[0] == G) {
				bw.write(now[1] + "\n");
				bw.flush();
				System.exit(0);
			}

			/* 위로 이동 (현재 층 + U) */
			if (now[0] + U <= F && !vstd[now[0] + U]) {
				vstd[now[0] + U] = true;
				Q.add(new int[] { now[0] + U, now[1] + 1 });
			}

			/* 아래로 이동 (현재 층 - D) */
			if (now[0] - D >= 1 && !vstd[now[0] - D]) {
				vstd[now[0] - D] = true;
				Q.add(new int[] { now[0] - D, now[1] + 1 });
			}
		}

		/* 목표 층에 도달할 수 없는 경우 */
		bw.write("use the stairs\n");
		bw.flush();
	}

}
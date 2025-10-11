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
		int N, M;
		int[] move;
		boolean[] vstd;
		Queue<int[]> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		move = new int[101];
		vstd = new boolean[101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			move[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		/* 시작점은 1번 칸 */
		vstd[1] = true;
		Q.offer(new int[] { 0, 1 }); // {이동 횟수, 현재 위치}

		/* BFS 탐색 시작 */
		while (!Q.isEmpty()) {
			int[] now = Q.poll();

			/* 100번 칸에 도달한 경우 최소 이동 횟수 갱신 */
			if (now[1] == 100) {
				bw.write(now[0] + "\n");
				break;
			}

			/* 주사위 굴리기 (1 ~ 6칸 이동 가능) */
			for (int i = 1; i <= 6; i++) {
				int next = now[1] + i;

				/* 100칸을 초과하는 경우는 무시 */
				if (next > 100)
					continue;

				/* 이동한 칸에 사다리나 뱀이 있을 경우 타고 이동 */
				while (move[next] != 0) {
					next = move[next];
				}

				/* 이미 방문한 칸이면 스킵 */
				if (vstd[next])
					continue;

				/* 방문 체크 후 큐에 삽입 */
				vstd[next] = true;
				Q.add(new int[] { now[0] + 1, next });
			}
		}

		bw.flush();
	}

}
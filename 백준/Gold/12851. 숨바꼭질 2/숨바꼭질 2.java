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
		int N, K, cnt = 0, minTime = Integer.MAX_VALUE;
		int[] time;
		Queue<Integer> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			bw.write("0\n1\n");
			bw.flush();
			System.exit(0);
		}

		time = new int[100001];

		/* 시작 위치 방문 처리 */
		time[N] = 1;
		Q.add(N);

		/* BFS */
		while (!Q.isEmpty()) {
			int now = Q.poll();

			/* 이미 최소 시간보다 더 오래 걸리는 경우는 볼 필요 없음 */
			if (time[now] > minTime)
				break;

			/* 3가지 이동 방법: -1, +1, *2 */
			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0)
					next = now - 1;
				else if (i == 1)
					next = now + 1;
				else
					next = now * 2;

				/* 다음 위치가 동생 위치인 경우 */
				if (next == K) {
					/* 현재 위치까지의 시간이 최단 시간 */
					minTime = time[now];
					/* 같은 최단 시간으로 도달하는 경우의 수 증가 */
					cnt++;
				}

				/* 범위를 벗어나면 무시 */
				if (next < 0 || next > 100000)
					continue;

				/* 아직 방문하지 않았거나 같은 시간으로 다시 방문 가능한 경우 */
				if (time[next] == 0 || time[next] == time[now] + 1) {
					/* 다음 위치의 도착 시간 기록 */
					time[next] = time[now] + 1;
					/* 큐에 추가하여 계속 탐색 */
					Q.add(next);
				}
			}

			/******************************************************************************************
			 * time:
			 *   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20
			 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───
			 * │ 0 │ 0 │ 0 │ 2 │ 1 │ 2 │ 0 │ 0 │ 0 │ 2 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ …
			 * └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───
			 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───
			 * │ 0 │ 0 │ 3 │ 2 │ 1 │ 2 │ 3 │ 3 │ 3 │ 2 │ 3 │ 3 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 3 │ …
			 * └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───
			 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───
			 * │ 0 │ 4 │ 3 │ 2 │ 1 │ 2 │ 3 │ 3 │ 3 │ 2 │ 3 │ 3 │ 4 │ 4 │ 0 │ 4 │ 0 │ 4 │ 4 │ 3 │ …
			 * └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───
			 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───
			 * │ 5 │ 4 │ 3 │ 2 │ 1 │ 2 │ 3 │ 3 │ 3 │ 2 │ 3 │ 3 │ 4 │ 4 │ 5 │ 4 │ 5 │ 4 │ 4 │ 3 │ …
			 * └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───
			 ******************************************************************************************/
		}

		bw.write(minTime + "\n" + cnt + "\n");
		bw.flush();
	}

}
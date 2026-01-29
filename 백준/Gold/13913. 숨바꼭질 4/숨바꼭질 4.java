import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[] vstd = new boolean[100001];
		int N, K;
		int[] prnt = new int[100001];
		Queue<Integer> Q = new LinkedList<>();
		Stack<Integer> path = new Stack<>();

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		/* 시작 위치 방문 처리 */
		vstd[N] = true;
		/* 시작 위치를 큐에 삽입 */
		Q.add(N);

		/* BFS */
		while (!Q.isEmpty()) {
			int now = Q.poll();

			/* 목표 위치에 도달한 경우 */
			if (now == K) {
				/* 부모 배열을 이용해 경로 역추적 */
				while (now != N) {
					/* 시작점까지 거슬러 올라가며 스택에 저장 */
					path.add(now);
					now = prnt[now];
				}

				path.add(N);
				break;
			}

			int X = 0;

			/* 세 가지 이동 방법을 순차적으로 처리 */
			for (int i = 0; i < 3; i++) {
				switch (i) {
				case 0:
					X = now * 2;
					break;
				case 1:
					X = now - 1;
					break;
				case 2:
					X = now + 1;
					break;
				}

				/* 범위를 벗어나거나 이미 방문한 경우 제외 */
				if (X < 0 || X > 100000 || vstd[X])
					continue;

				/* 방문 처리 */
				vstd[X] = true;
				/* X로 오기 전 위치는 now */
				prnt[X] = now;
				/* 큐에 다음 위치 추가 */
				Q.add(X);
			}
		}

		bw.write(path.size() - 1 + "\n");
		/* 스택에 저장된 경로를 pop 하면서 출력 (정방향) */
		while (!path.isEmpty())
			bw.write(path.pop() + " ");
		bw.write("\n");
		bw.flush();
	}

}
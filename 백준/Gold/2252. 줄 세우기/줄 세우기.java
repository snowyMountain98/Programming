import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<ArrayList<Integer>> hght = new ArrayList<>();
		ArrayList<Integer> lineUp = new ArrayList<>();
		int N, M, A, B;
		int[] cnt;
		Queue<Integer> Q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++)
			hght.add(new ArrayList<>());

		cnt = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			/* A가 B보다 먼저 와야 하므로, A → B로 간선을 추가 */
			hght.get(A).add(B);
			/* B의 진입 차수 증가 (B 앞에 서야 할 사람이 한 명 추가됨) */
			cnt[B]++;
		}

		/* 진입 차수가 0인 학생들을 큐에 넣음 */
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0)
				Q.add(i);
		}

		while (!Q.isEmpty()) {
			int now = Q.poll();

			/* 해당 학생을 결과 리스트에 추가 */
			lineUp.add(now);

			/* 해당 학생보다 뒤에 서야 하는 학생들을 확인 */
			for (int next : hght.get(now)) {
				/* 현재 학생을 처리했으므로, next 학생의 진입 차수를 1 감소 */
				cnt[next]--;

				/* 진입 차수가 0이 되면 큐에 추가 */
				if (cnt[next] == 0)
					Q.add(next);
			}
		}

		for (int i = 0; i < lineUp.size(); i++)
			bw.write(lineUp.get(i) + " ");
		bw.write("\n");
		bw.flush();
	}

}
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
		Queue<Integer> queue = new LinkedList<>();
		int N, K;
		ArrayList<Integer> jsphs = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			queue.offer(i);

		/* 큐가 빌 때까지 요세푸스 순열을 생성 */
		while (!queue.isEmpty()) {
			/* K-1번 앞에서 뽑은 숫자를 다시 큐에 넣고, K번째 숫자는 제거 */
			for (int i = 1; i < K; i++)
				queue.offer(queue.poll());

			/* K번째 사람을 리스트에 추가 */
			jsphs.add(queue.poll());
		}

		bw.write("<");
		for (int i = 0; i < jsphs.size(); i++) {
			bw.write(String.valueOf(jsphs.get(i)));

			if (i != jsphs.size() - 1)
				bw.write(", ");
		}
		bw.write(">\n");
		bw.flush();
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		PriorityQueue<Integer> pstv, ngtv;

		N = Integer.parseInt(br.readLine());

		/* 양수는 큰 수끼리 곱해야 이득이므로 내림차순 정렬 */
		pstv = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		/* 음수와 0은 작은 수끼리 묶기 위해 기본 오름차순 */
		ngtv = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			/* 양수는 양수 큐에 */
			if (num > 0)
				pstv.add(num);
			/* 0과 음수는 음수 큐에 */
			else
				ngtv.add(num);
		}

		bw.write(sum(pstv) + sum(ngtv) + "\n");
		bw.flush();
	}

	/**
	 * 우선순위 큐에 들어 있는 수들을 두 개씩 묶어서 최댓값을 만듦
	 */
	public static int sum(PriorityQueue<Integer> pQ) {
		int sum = 0;

		/* 두 개 이상 남아 있을 때까지 반복 */
		while (pQ.size() > 1) {
			int a = pQ.poll();
			int b = pQ.poll();

			/* 두 수 모두 1이 아닐 때만 곱하는 게 이득 */
			if (a != 1 && b != 1)
				sum += a * b;
			else
				sum += a + b;
		}

		/* 하나 남아 있으면 그대로 더함 */
		if (!pQ.isEmpty())
			sum += pQ.poll();

		return sum;
	}
}
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
		int N, cmprs = 0;
		PriorityQueue<Integer> card = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++)
			card.offer(Integer.parseInt(br.readLine()));

		/* 카드 합치기 연산 수행 */
		while (card.size() > 1) {
			int a = card.poll();
			int b = card.poll();

			cmprs += (a + b);	// 두 묶음을 합친 비용 누적

			card.offer(a + b);	// 합친 묶음을 다시 큐에 추가
		}

		bw.write(cmprs + "\n");
		bw.flush();
	}

}
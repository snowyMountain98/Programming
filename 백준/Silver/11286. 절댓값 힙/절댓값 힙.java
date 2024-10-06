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
		PriorityQueue<Integer> pQ;
		int N, x;

		pQ = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				/* 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력 */
				if (Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				/* 절댓값이 가장 작은 값을 출력 */
				else
					return Math.abs(o1) - Math.abs(o2);
			}
		});

		N = Integer.parseInt(br.readLine());

		while (N > 0) {
			x = Integer.parseInt(br.readLine());

			if (x == 0)
				bw.write((pQ.size() == 0 ? 0 : pQ.poll()) + "\n");
			else
				pQ.add(x);

			bw.flush();

			N--;
		}
	}

}
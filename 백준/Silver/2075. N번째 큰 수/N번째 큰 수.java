import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		PriorityQueue<Integer> pQ;

		N = Integer.parseInt(br.readLine());

		pQ = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}

		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				pQ.offer(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < N - 1; i++)
			pQ.poll();

		bw.write(pQ.poll() + "\n");
		bw.flush();
	}

}
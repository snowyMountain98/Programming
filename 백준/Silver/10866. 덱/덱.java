import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Deque<Integer> deque = new LinkedList<>();
		int N, X;

		N = Integer.parseInt(br.readLine());

		while (N > 0) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push_front":
				X = Integer.parseInt(st.nextToken());
				deque.addFirst(X);
				break;
			case "push_back":
				X = Integer.parseInt(st.nextToken());
				deque.addLast(X);
				break;
			case "pop_front":
				if (deque.isEmpty())
					bw.write("-1\n");
				else
					bw.write(deque.pollFirst() + "\n");
				break;
			case "pop_back":
				if (deque.isEmpty())
					bw.write("-1\n");
				else
					bw.write(deque.pollLast() + "\n");
				break;
			case "size":
				bw.write(deque.size() + "\n");
				break;
			case "empty":
				if (deque.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "front":
				if (deque.isEmpty())
					bw.write("-1\n");
				else
					bw.write(deque.getFirst() + "\n");
				break;
			case "back":
				if (deque.isEmpty())
					bw.write("-1\n");
				else
					bw.write(deque.getLast() + "\n");
				break;
			}

			bw.flush();
			N--;
		}
	}

}
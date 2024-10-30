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
		Queue<Integer> queue = new LinkedList<>();
		int N;
		String cmnd;

		N = Integer.parseInt(br.readLine());

		while (N > 0) {
			st = new StringTokenizer(br.readLine());

			cmnd = st.nextToken();

			switch (cmnd) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.poll() + "\n");
				break;
			case "size":
				bw.write(queue.size() + "\n");
				break;
			case "empty":
				if (queue.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "front":
				if (queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.peek() + "\n");
				break;
			case "back":
				if (queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(((LinkedList<Integer>) queue).getLast() + "\n");
				break;
			}

			bw.flush();

			N--;
		}
	}

}
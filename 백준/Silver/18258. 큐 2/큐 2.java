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
		Queue<String> queue = new LinkedList<>();
		String last = new String();
		StringTokenizer st;
		int n;

		n = Integer.parseInt(br.readLine());

		while (n > 0) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
			case "push":
				last = st.nextToken();
				queue.offer(last);
				break;
			case "pop":
				if (!queue.isEmpty())
					bw.write(queue.poll() + "\n");
				else
					bw.write("-1\n");
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
				if (!queue.isEmpty())
					bw.write(queue.peek() + "\n");
				else
					bw.write("-1\n");
				break;
			case "back":
				if (!queue.isEmpty())
					bw.write(last + "\n");
				else
					bw.write("-1\n");
				break;
			}

			n--;
		}

		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<String> dq = new ArrayDeque<>();
		StringTokenizer st;
		String cmd, x;
		int n;

		n = Integer.parseInt(br.readLine());

		while (n > 0) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();

			switch (cmd) {
			case "1":
				x = st.nextToken();
				dq.offerFirst(x);
				break;
			case "2":
				x = st.nextToken();
				dq.offerLast(x);
				break;
			case "3":
				bw.write((dq.isEmpty() ? "-1" : dq.pollFirst()) + "\n");
				break;
			case "4":
				bw.write((dq.isEmpty() ? "-1" : dq.pollLast()) + "\n");
				break;
			case "5":
				bw.write(dq.size() + "\n");
				break;
			case "6":
				bw.write((dq.isEmpty() ? "1" : "0") + "\n");
				break;
			case "7":
				bw.write((dq.isEmpty() ? "-1" : dq.peekFirst()) + "\n");
				break;
			case "8":
				bw.write((dq.isEmpty() ? "-1" : dq.peekLast()) + "\n");
				break;
			}

			n--;
		}

		bw.flush();
	}

}
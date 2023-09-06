import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<String> stack = new Stack<>();
		String cmd, x;
		int n;

		n = Integer.parseInt(br.readLine());

		while (n > 0) {
			st = new StringTokenizer(br.readLine());
			cmd = st.nextToken();

			switch (cmd) {
			case "1":
				x = st.nextToken();
				stack.push(x);
				break;
			case "2":
				if (stack.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(stack.pop() + "\n");
				break;
			case "3":
				bw.write(stack.size() + "\n");
				break;
			case "4":
				if (stack.isEmpty())
					bw.write("1" + "\n");
				else
					bw.write("0" + "\n");
				break;
			case "5":
				if (stack.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(stack.peek() + "\n");
				break;
			}

			n--;
		}
        
        bw.flush();
	}

}
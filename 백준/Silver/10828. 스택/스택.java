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
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		int N, X;
		String cmnd;

		N = Integer.parseInt(br.readLine());

		while (N > 0) {
			st = new StringTokenizer(br.readLine());

			cmnd = st.nextToken();

			switch (cmnd) {
			/* 정수 X를 스택에 넣는 연산이다. */
			case "push":
				X = Integer.parseInt(st.nextToken());
				stack.push(X);
				break;
			/* 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. */
			case "pop":
				if (!stack.isEmpty())
					bw.write(stack.pop() + "\n");
				else
					bw.write("-1\n");
				bw.flush();
				break;
			/* 스택에 들어있는 정수의 개수를 출력한다. */
			case "size":
				bw.write(stack.size() + "\n");
				bw.flush();
				break;
			/* 스택이 비어있으면 1, 아니면 0을 출력한다. */
			case "empty":
				if (stack.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				bw.flush();
				break;
			/* 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. */
			case "top":
				if (!stack.isEmpty())
					bw.write(stack.peek() + "\n");
				else
					bw.write("-1\n");
				bw.flush();
				break;
			}

			N--;
		}
	}

}
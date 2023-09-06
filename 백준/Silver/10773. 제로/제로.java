import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		int k, n, sum = 0;

		k = Integer.parseInt(br.readLine());

		while (k > 0) {
			n = Integer.parseInt(br.readLine());

			if (n == 0)
				stack.pop();
			else
				stack.push(n);

			k--;
		}

		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		bw.write(sum + "\n");
		bw.flush();
	}

}
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
		int N, good = 0;
		Stack<Character> stack;

		N = Integer.parseInt(br.readLine());

		while (N > 0) {
			stack = new Stack<>();

			String word = br.readLine();

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				if (stack.isEmpty()) {
					stack.add(c);
					continue;
				}

				if (stack.peek() == c)
					stack.pop();
				else
					stack.add(c);
			}

			if (stack.size() == 0)
				good++;

			N--;
		}

		bw.write(good + "\n");
		bw.flush();
	}

}
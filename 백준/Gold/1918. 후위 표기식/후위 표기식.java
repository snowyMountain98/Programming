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
		Stack<Character> stack = new Stack<>();
		String infix;
		StringBuilder postfix = new StringBuilder();

		infix = br.readLine();

		for (int i = 0; i < infix.length(); i++) {
			char now = infix.charAt(i);

			switch (now) {
			case '+':
			case '-':
			case '*':
			case '/':
				/* 스택의 top 연산자의 우선순위가 현재 연산자보다 높거나 같으면 pop */
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(now))
					postfix.append(stack.pop());
				/* 현재 연산자를 스택에 push */
				stack.push(now);
				break;
			case '(':
				/* 여는 괄호는 무조건 push */
				stack.push(now);
				break;
			case ')':
				/* 여는 괄호가 나올 때까지 스택에서 pop */
				while (!stack.isEmpty() && stack.peek() != '(')
					postfix.append(stack.pop());
				/* 여는 괄호 '(' 제거 */
				stack.pop();
				break;
			default:
				/* 피연산자는 바로 결과에 추가 */
				postfix.append(now);
			}
		}

		/* 남아 있는 연산자 모두 결과에 추가 */
		while (!stack.isEmpty())
			postfix.append(stack.pop());
		
		/**
		 * A*(B+C)
		 * 
		 *  ch ┃   stack   ┃ postfix
		 * ━━━━╋━━━━━━━━━━━╋━━━━━━━━━ 
		 *  A  ┃ []        ┃ A
		 * ────╂───────────╂─────────
		 *  *  ┃ [*]       ┃ A
		 * ────╂───────────╂─────────
		 *  (  ┃ [*, (]    ┃ A
		 * ────╂───────────╂─────────
		 *  B  ┃ [*, (]    ┃ AB
		 * ────╂───────────╂─────────
		 *  +  ┃ [*, (, +] ┃ AB
		 * ────╂───────────╂─────────
		 *  C  ┃ [*, (, +] ┃ ABC
		 * ────╂───────────╂─────────
		 *  )  ┃ [*]       ┃ ABC+
		 * ────╂───────────╂─────────
		 *     ┃ []        ┃ ABC+*
		 */

		bw.write(postfix.toString() + "\n");
		bw.flush();
	}

	/**
	 * 연산자의 우선순위를 반환
	 */
	public static int priority(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;	// 덧셈, 뺄셈 우선순위
		case '*':
		case '/':
			return 2;	// 곱셈, 나눗셈 우선순위
		}

		return 0;
	}
}
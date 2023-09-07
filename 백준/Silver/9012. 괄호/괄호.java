import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Stack<Character> stack;
		String ps, result;
		int t;

		t = scn.nextInt();

		while (t > 0) {
			ps = scn.next();
			stack = new Stack<>();
			result = "YES";

			CHECK:
			for (int i = 0; i < ps.length(); i++) {
				switch (ps.charAt(i)) {
				case '(':
					stack.push('(');
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						result = "NO";
						break CHECK;
					}
					stack.pop();
					break;
				}
			}

			/**************************************************
			 * ps : (()())((()))
			 * stack : [(] → [(, (] → [(] → [(, (] → [(] → []
			 * → [(] → [(, (] → [(, (, (] → [(, (] → [(] → []
			 **************************************************/

			if (!stack.isEmpty())
				result = "NO";

			System.out.println(result);

			t--;
		}
	}

}
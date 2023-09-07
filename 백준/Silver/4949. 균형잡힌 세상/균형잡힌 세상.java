import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Stack<Character> stack;
		String str, result;

		do {
			str = scn.nextLine();
			stack = new Stack<>();
			result = "yes";

			if (".".equals(str))
				break;

			CHECK:
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case '(':
				case '[':
					stack.push(str.charAt(i));
					break;
				case ')':
				case ']':
					if (stack.isEmpty()
						|| (str.charAt(i) == ')' && stack.peek() != '(')
						|| (str.charAt(i) == ']' && stack.peek() != '[')) {
						result = "no";
						break CHECK;
					}
					stack.pop();
					break;
				default:
					break;
				}
			}

			if (!stack.isEmpty())
				result = "no";

			System.out.println(result);
		} while (true);
	}

}
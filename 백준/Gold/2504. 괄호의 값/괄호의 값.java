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
		int tmp = 1, rslt = 0;
		char[] str;
		Stack<Character> stack = new Stack<>();

		str = br.readLine().toCharArray();

		/* 문자열을 처음부터 끝까지 순회하며 괄호 계산 */
		for (int i = 0; i < str.length; i++) {
			/* 여는 소괄호 '(' → 스택에 추가하고 가중치 *2 */
			if (str[i] == '(') {
				stack.push(str[i]);
				tmp *= 2;
			}

			/* 여는 대괄호 '[' → 스택에 추가하고 가중치 *3 */
			if (str[i] == '[') {
				stack.push(str[i]);
				tmp *= 3;
			}

			/* 닫는 소괄호 ')' → 유효성 검사 및 계산 */
			if (str[i] == ')') {
				/* 스택이 비었거나 짝이 맞지 않으면 잘못된 괄호 */
				if (stack.isEmpty() || stack.peek() != '(') {
					rslt = 0;
					break;
				}

				/* 바로 이전 문자가 '('라면 완성된 괄호쌍 → 결과에 tmp 더하기 */
				if (str[i - 1] == '(')
					rslt += tmp;

				/* 스택에서 '(' 제거하고 가중치 나누기 2 (깊이 감소) */
				stack.pop();
				tmp /= 2;
			}

			/* 닫는 대괄호 ']' → 유효성 검사 및 계산 */
			if (str[i] == ']') {
				/* 스택이 비었거나 짝이 맞지 않으면 잘못된 괄호 */
				if (stack.isEmpty() || stack.peek() != '[') {
					rslt = 0;
					break;
				}

				/* 바로 이전 문자가 '['라면 완성된 괄호쌍 → 결과에 tmp 더하기 */
				if (str[i - 1] == '[')
					rslt += tmp;

				/* 스택에서 '[' 제거하고 가중치 나누기 3 (깊이 감소) */
				stack.pop();
				tmp /= 3;
			}
		}

		/**************************************************
		 * str: (()[[]])([])
		 * 
		 *  i ┃ str[i] ┃   stack   ┃  tmp   ┃  rslt
		 * ━━━╋━━━━━━━━╋━━━━━━━━━━━╋━━━━━━━━╋━━━━━━━━━
		 *  0 ┃   (    ┃ {(}       ┃   2    ┃    0
		 * ───╂────────╂───────────╂────────╂─────────
		 *  1 ┃   (    ┃ {(, (}    ┃ 2*2=4  ┃    0
		 * ───╂────────╂───────────╂────────╂─────────
		 *  2 ┃   )    ┃ {(}       ┃ 4/2=2  ┃  0+4=4
		 * ───╂────────╂───────────╂────────╂─────────
		 *  3 ┃   [    ┃ {(, [}    ┃ 2*3=6  ┃    4
		 * ───╂────────╂───────────╂────────╂─────────
		 *  4 ┃   [    ┃ {(, [, [} ┃ 6*3=18 ┃    4
		 * ───╂────────╂───────────╂────────╂─────────
		 *  5 ┃   ]    ┃ {(, [}    ┃ 18/3=6 ┃ 4+18=22
		 * ───╂────────╂───────────╂────────╂─────────
		 *  6 ┃   ]    ┃ {(}       ┃ 6/3=2  ┃   22
		 * ───╂────────╂───────────╂────────╂─────────
		 *  7 ┃   )    ┃ {}        ┃ 2/2=1  ┃   22
		 * ───╂────────╂───────────╂────────╂─────────
		 *  8 ┃   (    ┃ {(}       ┃ 1*2=2  ┃   22
		 * ───╂────────╂───────────╂────────╂─────────
		 *  9 ┃   [    ┃ {(, [}    ┃ 2*3=6  ┃   22
		 * ───╂────────╂───────────╂────────╂─────────
		 * 10 ┃   ]    ┃ {(}       ┃ 6/3=2  ┃ 22+6=28
		 * ───╂────────╂───────────╂────────╂─────────
		 * 11 ┃   )    ┃ {}        ┃ 2/2=1  ┃   28
		 **************************************************/

		if (stack.isEmpty())
			bw.write(rslt + "\n");
		else
			bw.write(0 + "\n");
		bw.flush();
	}

}
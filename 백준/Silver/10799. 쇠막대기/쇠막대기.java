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
		char[] ironRod;
		Stack<Character> stack = new Stack<>();
		int cnt = 0;

		ironRod = br.readLine().toCharArray();

		for (int i = 0; i < ironRod.length; i++) {
			/* 현재 문자가 '('인 경우, 스택에 추가 */
			if (ironRod[i] == '(')
				stack.push(ironRod[i]);

			/* 현재 문자가 ')'인 경우 */
			else if (ironRod[i] == ')') {
				/* 스택에서 '(' 하나를 제거 */
				stack.pop();

				/* 직전 문자가 '('이면 레이저 */
				if (ironRod[i - 1] == '(')
					/* 레이저로 인해 현재 스택에 남아 있는 '('의 개수만큼 막대기가 잘림 */
					cnt += stack.size();

				/* 직전 문자가 ')'이면 쇠막대기의 끝 */
				else
					/* 막대기의 끝 부분이므로 잘린 조각 하나 추가 */
					cnt++;
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

}
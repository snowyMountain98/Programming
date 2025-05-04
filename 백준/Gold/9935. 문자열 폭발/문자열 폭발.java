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
		String str, bomb;
		StringBuilder sb = new StringBuilder();

		str = br.readLine();
		bomb = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			int len = bomb.length();
			int size = stack.size();

			/*스택의 크기가 폭발 문자열보다 크거나 같을 때*/
			/* 폭발 문자열이 포함되어 있는지 확인 */
			if (size >= len) {
				boolean hasBomb = true;

				/* 스택의 끝에서부터 폭발 문자열과 비교 */
				for (int j = 0; j < len; j++) {
					if (bomb.charAt(j) != stack.get(size - len + j)) {
						hasBomb = false;
						break;
					}
				}

				/* 폭발 문자열이 존재하면 제거 */
				if (hasBomb) {
					for (int j = 0; j < len; j++)
						stack.pop();
				}
			}
		}

		/************************************************************
		 * stack:
		 *   [m] 
		 * → [m, i]
		 * → [m, i, r]
		 * → [m, i, r, k]
		 * → [m, i, r, k, o]
		 * → [m, i, r, k, o, v]
		 * → [m, i, r, k, o, v, C]
		 * → [m, i, r, k, o, v, C, 4] ☞ bomb!
		 * → [m, i, r, k, o, v]
		 * → [m, i, r, k, o, v, n]
		 * → [m, i, r, k, o, v, n, i]
		 * → [m, i, r, k, o, v, n, i, z]
		 * → [m, i, r, k, o, v, n, i, z, C]
		 * → [m, i, r, k, o, v, n, i, z, C, C]
		 * → [m, i, r, k, o, v, n, i, z, C, C, 4] ☞ bomb!
		 * → [m, i, r, k, o, v, n, i, z, C]
		 * → [m, i, r, k, o, v, n, i, z, C, 4] ☞ bomb!
		 * → [m, i, r, k, o, v, n, i, z]
		 ************************************************************/

		if (stack.isEmpty())
			bw.write("FRULA\n");
		else {
			for (char ch : stack)
				sb.append(ch);

			bw.write(sb.toString() + "\n");
		}
		bw.flush();
	}

}
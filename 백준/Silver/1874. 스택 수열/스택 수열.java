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
		int n, num, crnt;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		crnt = 1;

		/* n번 반복하여 수열의 각 숫자를 입력받고 처리 */
		while (n > 0) {
			num = Integer.parseInt(br.readLine());

			/* 입력받은 숫자 num까지 스택에 push */
			while (crnt <= num) {
				stack.push(crnt);
				sb.append("+\n");
				
				crnt++;
			}

			/* 스택의 top이 입력받은 num과 일치하면 pop */
			if (stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			}
			/* 스택의 top이 num과 다르면 수열을 만들 수 없으므로 "NO" 출력 */
			else {
				bw.write("NO");
				bw.flush();
				return;
			}

			n--;
		}
		
		/**************************************************
		 *    │     PUSH     │ POP │    STACK
		 * ───┼──────────────┼─────┼──────────────
		 *  4 │ [1, 2, 3, 4] │ [4] │ [1, 2, 3]
		 *  3 │              │ [3] │ [1, 2]
		 *  6 │ [5, 6]       │ [6] │ [1, 2, 5]
		 *  8 │ [7, 8]       │ [8] │ [1, 2, 5, 7] 
		 *  7 │              │ [7] │ [1, 2, 5]
		 *  5 │              │ [5] │ [1, 2]
		 *  2 │              │ [2] │ [1]
		 *  1 │              │ [1] │ 
		 **************************************************/

		bw.write(sb.toString());
		bw.flush();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Deque<Character> left, right;
		int M;
		String word, cmnd;

		word = br.readLine();

		left = new LinkedList<>();
		right = new LinkedList<>();

		for (int i = 0; i < word.length(); i++)
			left.add(word.charAt(i));

		M = Integer.parseInt(br.readLine());

		while (M > 0) {
			st = new StringTokenizer(br.readLine());
			cmnd = st.nextToken();

			switch (cmnd) {
			case "L":
				/* 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시) */
				if (!left.isEmpty())
					right.addFirst(left.pollLast());
				break;
			case "D":
				/* 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시) */
				if (!right.isEmpty())
					left.addLast(right.pollFirst());
				break;
			case "B":
				/* 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시) */
				if (!left.isEmpty())
					left.pollLast();
				break;
			case "P":
				/* 문자를 커서 왼쪽에 추가 */
				left.addLast(st.nextToken().charAt(0));
				break;
			}

			M--;
		}
		
		/**************************************************
		 *      │        left       │   right
		 * ─────┼───────────────────┼───────────
		 * P x	│ [a, b, c, d, x]   │ []
		 * ─────┼───────────────────┼───────────
		 * L	│ [a, b, c, d]      │ [x]
		 * ─────┼───────────────────┼───────────
		 * P y	│ [a, b, c, d, y]   │ [x]
		 **************************************************/

		while (!left.isEmpty())
			bw.write(left.pollFirst());

		while (!right.isEmpty())
			bw.write(right.pollFirst());

		bw.write("\n");
		bw.flush();
	}

}

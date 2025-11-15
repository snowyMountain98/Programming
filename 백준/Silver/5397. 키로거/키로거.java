import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Character> pswrd;
		ListIterator<Character> itrtr;
		int T;
		String log;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			log = br.readLine();
			pswrd = new LinkedList<>();
			itrtr = pswrd.listIterator();

			for (char c : log.toCharArray()) {
				switch (c) {
				/* 백스페이스 */
				case '-':
					if (itrtr.hasPrevious()) {
						itrtr.previous();
						itrtr.remove();
					}
					break;
				/* 왼쪽으로 1만큼 커서 이동 */
				case '<':
					if (itrtr.hasPrevious())
						itrtr.previous();
					break;
				/* 오른쪽으로 1만큼 커서 이동 */
				case '>':
					if (itrtr.hasNext())
						itrtr.next();
					break;
				/* 비밀번호의 일부 */
				default:
					itrtr.add(c);
					break;
				}
			}

			for (char c : pswrd)
				bw.write(c);
			bw.write("\n");
			T--;
		}

		bw.flush();
	}

}
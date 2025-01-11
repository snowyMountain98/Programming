import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayDeque<Integer> dQ;
		boolean rvrs, error;
		int T, n;
		String p;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			p = br.readLine();
			n = Integer.parseInt(br.readLine());
			dQ = new ArrayDeque<>();

			/* 입력된 배열을 파싱하여 Deque에 삽입 */
			st = new StringTokenizer(br.readLine(), ",[]");
			for (int i = 0; i < n; i++)
				dQ.add(Integer.parseInt(st.nextToken()));

			rvrs = false;
			error = false;

			/* 명령어 문자열 처리 */
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R')
					rvrs = !rvrs; // 뒤집기 플래그 토글
				else if (p.charAt(i) == 'D') {
					if (dQ.isEmpty()) {
						error = true; // 에러 발생
						break;
					}

					if (rvrs)
						dQ.pollLast(); // 뒤집힌 상태에서 뒤에서 제거
					else
						dQ.pollFirst(); // 정상 상태에서 앞에서 제거
				}
			}

			if (error) {
				bw.write("error\n");
			} else {
				bw.write("[");

				if (!dQ.isEmpty()) {
					if (rvrs) {
						while (dQ.size() > 1) {
							bw.write(dQ.pollLast() + ",");
						}
						bw.write(dQ.pollLast() + "");
					} else {
						while (dQ.size() > 1) {
							bw.write(dQ.pollFirst() + ",");
						}
						bw.write(dQ.pollFirst() + "");
					}
				}

				bw.write("]\n");
			}

			T--;
		}

		bw.flush();
	}

}
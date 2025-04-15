import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] brkn = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, cnt;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		cnt = Math.abs(N - 100);

		/* 고장난 버튼이 있는 경우 */
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				brkn[Integer.parseInt(st.nextToken())] = true;

			for (int i = 0; i < 1000000; i++) {
				if (!psbl(i))
					continue;

				cnt = Math.min(cnt, Math.abs(N - i) + String.valueOf(i).length());
			}
		} else
			cnt = Math.min(cnt, String.valueOf(N).length());

		bw.write(cnt + "\n");
		bw.flush();
	}

	/* 숫자 버튼만 눌러서 이동이 가능한지 체크 */
	public static boolean psbl(int num) {
		String strNum = String.valueOf(num);

		/* 고장난 버튼이 포함되어 있는지 확인 */
		for (int i = 0; i < strNum.length(); i++) {
			if (brkn[strNum.charAt(i) - '0'])
				return false;
		}

		return true;
	}

}
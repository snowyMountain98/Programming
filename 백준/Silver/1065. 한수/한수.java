import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int hansu = 0;

		N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			/* 한 자리 수 또는 두 자리 수는 무조건 한수이므로 카운트 증가 */
			if (i < 100) {
				hansu++;
				continue;
			}

			/* 세 자리 수일 경우, 각 자릿수를 분리하여 변수 a, b, c에 저장 */
			int a = i / 100;
			int b = (i / 10) % 10;
			int c = i % 10;

			/* 한수 조건: 각 자릿수의 등차가 동일하면 한수 */
			if (a - b == b - c)
				hansu++;
		}

		bw.write(hansu + "\n");
		bw.flush();
	}

}
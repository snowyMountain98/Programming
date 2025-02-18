import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long S, sum = 0, N = 0;

		S = Long.parseLong(br.readLine());

		/* 1부터 시작해서 합계를 누적하며 반복 */
		for (int i = 1;; i++) {
			/* 현재까지의 합계가 S보다 크면 반복 종료 */
			if (sum > S)
				break;

			sum += i;
			N++;
		}

		/* N-1 값을 출력 (마지막으로 더한 값은 S를 초과했으므로 제외) */
		bw.write(N - 1 + "\n");
		bw.flush();
	}

}
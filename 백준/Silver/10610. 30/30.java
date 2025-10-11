import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int[] num;
		String N;

		N = br.readLine();

		num = new int[N.length()];

		for (int i = 0; i < N.length(); i++)
			num[i] = N.charAt(i) - '0';

		Arrays.sort(num);	// 오름차순 정렬

		/* 모든 자리수의 합을 계산 */
		for (int i = 0; i < num.length; i++)
			sum += num[i];

		/**
		 * 30의 배수 조건:
		 * 1. 0이 반드시 하나 포함되어야 함 (가장 작은 수가 0인지 확인)
         * 2. 모든 자리수의 합이 3의 배수여야 함
		 */
		if (sum % 3 != 0 || num[0] != 0)
			bw.write("-1\n");
		else {
			/* 30의 배수가 가능한 경우 큰 자리수부터 출력 */
			for (int i = num.length - 1; i >= 0; i--)
				bw.write(num[i] + "");

			bw.write("\n");
		}

		bw.flush();
	}

}
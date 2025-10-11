import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, s, e, diff = Integer.MAX_VALUE;
		int[] sltn, answr;

		N = Integer.parseInt(br.readLine());

		sltn = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			sltn[i] = Integer.parseInt(st.nextToken());

		/* 오름차순 정렬 */
		Arrays.sort(sltn);

		s = 0;		// 시작 포인터
		e = N - 1;	// 끝 포인터
		answr = new int[2];

		/* 두 포인터가 만날 때까지 반복 */
		while (s < e) {
			int sum = sltn[s] + sltn[e];	// 두 용액의 합

			/* 현재 합이 0에 더 가까우면 정답 갱신 */
			if (diff > Math.abs(sum)) {
				answr[0] = sltn[s];
				answr[1] = sltn[e];

				diff = Math.abs(sum);

				if (diff == 0)	// 0이면 종료
					break;
			}

			/* 합이 양수면 값을 줄이기 위해 e 감소 */
			if (sum > 0)
				e--;
			/* 합이 음수면 s 증가 */
			else
				s++;
		}

		bw.write(answr[0] + " " + answr[1] + "\n");
		bw.flush();
	}

}
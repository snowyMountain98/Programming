import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Long> prime = new ArrayList<>();
		boolean[] isPrime;
		int N, sum = 0, cnt = 0, left, right;

		N = Integer.parseInt(br.readLine());

		isPrime = new boolean[N + 1];

		for (int i = 2; i <= N; i++)
			isPrime[i] = true;

		/* 에라토스테네스의 체 */
		for (long i = 2; i <= N; i++) {
			if (!isPrime[(int) i])
				continue;

			prime.add(i);	// 소수이므로 리스트에 추가

			/* i의 배수들을 소수가 아님 */
			for (long j = i * i; j <= N; j += i)
				isPrime[(int) j] = false;
		}

		left = 0;
		right = 0;

		/* 투 포인터를 이용해 소수의 연속 합으로 N을 만들 수 있는 경우의 수 찾기 */
		while (left < prime.size() && right < prime.size()) {
			if (sum == N)
				cnt++;	// 합이 N과 같으면 경우의 수 증가

			if (sum < N)
				sum += prime.get(right++);	// 합이 작으면 오른쪽 포인터 확장
			else
				sum -= prime.get(left++);	// 합이 크면 왼쪽 포인터 이동
		}

		/* N 자체가 소수이면 위에서 카운팅에 포함되지 않았으므로 +1 */
		if (isPrime[N])
			bw.write((cnt + 1) + "\n");
		else
			bw.write(cnt + "\n");
		bw.flush();
	}

}
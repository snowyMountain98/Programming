import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, M, N, x, y;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken()) - 1;	// (1~M)을 0~M-1로 변환
			y = Integer.parseInt(st.nextToken()) - 1;	// (1~N)을 0~N-1로 변환

			int year = -1;	// 결과를 저장할 변수 (-1이면 불가능한 해)

			/**
			 * year = k + 1 (실제 연도)
			 * k는 0부터 시작하는 값으로,
			 * (x, y)에 해당하는 해를 찾기 위해 x부터 M씩 증가시키며 탐색
			 * 탐색 범위는 최소공배수(M, N) 미만까지만 확인하면 됨 (주기가 반복되므로)
			 */
			for (int k = x; k < lcm(M, N); k += M) {
				/* y 주기에 맞는 연도인지 확인 */
				if (k % N == y) {
					year = k + 1;	// 0-index 보정 → 실제 해(year)
					break;
				}
			}

			bw.write(year + "\n");
			T--;
		}

		bw.flush();
	}

	/* 최소공배수(LCM) 계산 함수 */
	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	/* 최대공약수(GCD) 계산 함수 (유클리드 호제법) */
	public static int gcd(int a, int b) {
		if (b != 0)
			return gcd(b, a % b);

		return a;
	}

}
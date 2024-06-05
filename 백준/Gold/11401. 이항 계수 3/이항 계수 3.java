import java.util.Scanner;

public class Main {
	static int P = 1000000007;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N, K;
		long nmrtr, dnmnt;

		N = scn.nextInt();
		K = scn.nextInt();

		K = Math.min(K, N - K);

		/**************************************************
		 * 【페르마의 소정리】
		 * a는 정수, p는 소수이며 a⫮p일 때
		 * a^p ≡ a(mod p)
		 * ⇒ a^p mod p ≡ a mod p
		 * 
		 * a^(p-1) ≡ 1 (mod p)
		 * ⇒ a × a^(p-2) ≡ 1 (mod p)
		 **************************************************/

		/********************************************************************************
		 *    N!
		 * ──────── mod P	= (N! × (K!(N - K)!)^(-1)) mod P
		 * K!(N-K)!		= ((N! mod P) × (K!(N - K)!)^(-1) mod P) mod P
		 *			= ((N! mod P) × (K!(N - K)!)^(1000000007 - 2) mod P) mod P
		 ********************************************************************************/

		/* N! mod P */
		nmrtr = fctrl(N);

		/* (K!(N - K)!)^(1000000007 - 2) mod P */
		dnmnt = power(fctrl(K) * fctrl(N - K), P - 2);

		System.out.println((nmrtr * dnmnt) % P);
	}

	/* 팩토리얼 */
	public static long fctrl(int N) {
		long rtn = 1;

		for (int i = 2; i <= N; i++)
			rtn = (rtn * (i % P)) % P;

		return rtn;
	}

	/* 곱셈 */
	public static long power(long A, int B) {
		if (B == 0)
			return 1;
		else if (B == 1)
			return A % P;

		long rtn = power(A, B / 2);

		if (B % 2 == 0)
			return (rtn * rtn) % P;
		else
			return ((rtn * rtn) % P * (A % P)) % P;
	}

}
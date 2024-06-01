import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int A, B, C;

		A = scn.nextInt();
		B = scn.nextInt();
		C = scn.nextInt();

		/**************************************************
		 * 지수법칙 : a^(n + m) = a^n * a^m
		 * 모듈러 법칙 : (a * b) % c = (a % c * b % c) % c
		 **************************************************/

		System.out.println(mltpl(A, B, C));
	}

	public static long mltpl(int A, int B, int C) {
		if (B == 0)
			return 1;
		else if (B == 1)
			return A % C;

		long rtn = mltpl(A, B / 2, C);

		if (B % 2 == 0)
			return (rtn * rtn) % C;
		else
			return ((rtn * rtn) % C * (A % C)) % C;
	}

}
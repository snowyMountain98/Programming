import java.util.Scanner;

public class Main {
	static int N;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long B;
		int[][] A, rslt;

		N = scn.nextInt();
		B = scn.nextLong();

		A = new int[N][N];
		rslt = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = scn.nextInt();
				A[i][j] %= 1000;	// 행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0
			}
		}

		rslt = power(A, B);

		/**************************************************
		 * 	7 10  →  37  54  →  199 290  →  69 558 
		 * 15 22     81 118     435 634     337 406 
		 **************************************************/

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(rslt[i][j] + " ");
			System.out.println();
		}
	}

	public static int[][] power(int[][] A, long B) {
		if (B == 1)
			return A;

		int[][] rtrn = power(A, B / 2);

		if (B % 2 == 0)
			return mltpl(rtrn, rtrn);
		else
			return mltpl(mltpl(rtrn, rtrn), A);
	}

	public static int[][] mltpl(int[][] a, int[][] b) {
		int[][] rtrn = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++)
					rtrn[i][j] += (a[i][k] * b[k][j]) % 1000;
				rtrn[i][j] %= 1000;
			}
		}

		return rtrn;
	}
	
}
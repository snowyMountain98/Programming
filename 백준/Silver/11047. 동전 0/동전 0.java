import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N, K, min = 0;
		int[] A;

		N = scn.nextInt();
		K = scn.nextInt();

		A = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			A[i] = scn.nextInt();
		}

		for (int i = 0; i < N; i++) {
			if (A[i] <= K) {
				min += K / A[i];
				K %= A[i];
			}
		}

		System.out.println(min);
	}

}
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N, sum = 0;
		int[] P;

		N = scn.nextInt();

		P = new int[N];
		for (int i = 0; i < N; i++)
			P[i] = scn.nextInt();

		Arrays.sort(P);

		for (int i = 0; i < N; i++)
			sum += P[i] * (N - i);

		System.out.println(sum);
	}

}
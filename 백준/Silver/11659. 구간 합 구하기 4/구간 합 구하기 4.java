import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, m, i, j;
		int[] sum;

		n = scn.nextInt();
		m = scn.nextInt();

		sum = new int[n + 1];
		for (int k = 1; k <= n; k++)
			sum[k] = sum[k - 1] + scn.nextInt();

		while (m > 0) {
			i = scn.nextInt();
			j = scn.nextInt();

			System.out.println(sum[j] - sum[i - 1]);
			m--;
		}
	}

}
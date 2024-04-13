import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, k, max = Integer.MIN_VALUE, sum = 0;
		int[] tmp;

		n = scn.nextInt();
		k = scn.nextInt();

		tmp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			tmp[i] = scn.nextInt();
			sum += tmp[i];

			if (i >= k) {
				sum -= tmp[i - k];
				max = Math.max(max, sum);
			}
		}

		System.out.println(max);
	}

}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] wine, max;
		int n = Integer.MIN_VALUE;

		n = scn.nextInt();

		wine = new int[10001];
		for (int i = 1; i <= n; i++)
			wine[i] = scn.nextInt();

		max = new int[10001];

		max[1] = wine[1];
		max[2] = wine[1] + wine[2];
		max[3] = Math.max(max[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));

		for (int i = 4; i <= n; i++)
			max[i] = Math.max(max[i - 1], Math.max(max[i - 2] + wine[i], max[i - 3] + wine[i - 1] + wine[i]));

		/****************************************
		 * wine : [6, 10, 13,  9,  8,  1]
		 * max  : [6, 16, 23, 28, 33, 33]
		 ****************************************/
		
		System.out.println(max[n]);
	}

}
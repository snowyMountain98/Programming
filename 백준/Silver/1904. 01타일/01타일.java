import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] tile;
		int n;

		n = scn.nextInt();

		tile = new int[1000001];

		tile[1] = 1;
		tile[2] = 2;
		
		/**************************************************
		 *    ┌───┐
		 * 1: │ 1 │
		 *    └───┘
		 *    ┌───┬───┐ ┌───┬───┐
		 * 2: │ 0 │ 0 │ │ 1 │ 1 │ 
		 *    └───┴───┘ └───┴───┘
		 *    ┌───────┐ ┌───┬───┐   ┌───────┐ ┌───┐
		 * n: │ n - 1 │&│ 0 │ 0 │ + │ n - 2 │&│ 1 │
		 *    └───────┘ └───┴───┘   └───────┘ └───┘
		 **************************************************/

		for (int i = 3; i <= n; i++)
			tile[i] = (tile[i - 1] + tile[i - 2]) % 15746;

		System.out.println(tile[n]);
	}

}
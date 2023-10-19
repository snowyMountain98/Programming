import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		int[] step, max;

		n = scn.nextInt();

		step = new int[300];
		max = new int[300];

		for (int i = 0; i < n; i++)
			step[i] = scn.nextInt();

		max[0] = step[0];
		max[1] = step[0] + step[1];
		max[2] = Math.max(step[0] + step[2], step[1] + step[2]);

		for (int i = 3; i < n; i++)
			max[i] = Math.max(max[i - 2] + step[i], max[i - 3] + step[i - 1] + step[i]);

		/****************************************
		 * 1)             2)
		 * ┌───┬───┬───┐  ┌───┬───┬───┬───┐
		 * │ O │ X │ O │  │ O │ X │ O │ O │
		 * └───┴───┴───┘  └───┴───┴───┴───┘
		 ****************************************/
		
		System.out.println(max[n - 1]);
	}

}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] oprt;
		int n;

		n = scn.nextInt();

		oprt = new int[n + 1];

		for (int i = 2; i <= n; i++)
			oprt[i] = Math.min(i % 3 == 0 ? oprt[i / 3] : oprt[i - 1], i % 2 == 0 ? oprt[i / 2] : oprt[i - 1]) + 1;
		
		/****************************************
		 * n : 10
		 * oprt : [0, 1, 1, 2, 3, 2, 3, 3, 2, 3]
		 ****************************************/

		System.out.println(oprt[n]);
	}

}
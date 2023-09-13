import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		int[] dvs;    // Divisor

		n = scn.nextInt();

		dvs = new int[n];
		for (int i = 0; i < n; i++)
			dvs[i] = scn.nextInt();

		Arrays.sort(dvs);

		if (n % 2 == 0)
			System.out.println(dvs[0] * dvs[n - 1]);
		else
			System.out.println(dvs[n / 2] * dvs[n / 2]);
	}

}
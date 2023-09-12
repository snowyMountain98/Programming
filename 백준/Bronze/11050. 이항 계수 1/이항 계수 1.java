import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, k;
		int nmr = 1, dnm = 1;

		n = scn.nextInt();
		k = scn.nextInt();

		for (int i = n; i > n - k; i--)
			nmr *= i;

		for (int i = k; i > 0; i--)
			dnm *= i;

		System.out.println(nmr / dnm);
	}

}
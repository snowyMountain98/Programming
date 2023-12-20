import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, length = 0;
		int[] a, lngIncPrtSqn;

		n = scn.nextInt();

		a = new int[n + 1];
		lngIncPrtSqn = new int[n + 1];

		for (int i = 1; i <= n; i++)
			a[i] = scn.nextInt();

		lngIncPrtSqn[1] = 1;

		for (int i = 2; i <= n; i++) {
			lngIncPrtSqn[i] = 1;

			for (int j = 1; j < i; j++)
				if (a[i] > a[j])
					lngIncPrtSqn[i] = Math.max(lngIncPrtSqn[i], lngIncPrtSqn[j] + 1);
		}

		for (int i = 1; i <= n; i++)
			length = Math.max(lngIncPrtSqn[i], length);

		System.out.println(length);
	}

}
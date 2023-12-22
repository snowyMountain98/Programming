import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, length = 0;
		int[] a, lngIncSbs, lngDcrSbs;

		n = scn.nextInt();

		a = new int[n + 1];
		lngIncSbs = new int[n + 1];
		lngDcrSbs = new int[n + 1];

		for (int i = 1; i <= n; i++)
			a[i] = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			lngIncSbs[i] = 1;
			lngDcrSbs[n - i + 1] = 1;

			for (int j = 1; j < i; j++) {
				if (a[i] > a[j])
					lngIncSbs[i] = Math.max(lngIncSbs[i], lngIncSbs[j] + 1);

				if (a[n - i + 1] > a[n - j + 1])
					lngDcrSbs[n - i + 1] = Math.max(lngDcrSbs[n - i + 1], lngDcrSbs[n - j + 1] + 1);
			}
		}

		/**************************************************
		 * a		: [1, 5, 2, 1, 4, 3, 4, 5, 2, 1] 
		 * lngIncSbs	: [1, 2, 2, 1, 3, 3, 4, 5, 2, 1]
		 * lngDcrSbs	: [1, 5, 2, 1, 4, 3, 3, 3, 2, 1]
		 **************************************************/
		
		for (int i = 1; i <= n; i++)
			length = Math.max(length, lngIncSbs[i] + lngDcrSbs[i] - 1);

		System.out.println(length);
	}

}
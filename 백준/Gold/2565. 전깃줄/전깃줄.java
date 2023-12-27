import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<int[]> elcPl = new ArrayList<>();
		int[] lngIncSbs;
		int n, elcWr = 0;

		n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			int[] tmp = new int[2];
			tmp[0] = scn.nextInt();
			tmp[1] = scn.nextInt();

			elcPl.add(tmp);
		}

		Collections.sort(elcPl, new Comparator<int[]>() {
			@Override
			public int compare(int[] s1, int[] s2) {
				if (s1[0] < s2[0])
					return -1;
				else if (s1[0] > s2[0])
					return 1;
				return 0;
			}
		});

		/********************************************************************************
		 * elcPl : [[1, 8], [2, 2], [3, 9], [4, 1], [6, 4], [7, 6], [9, 7], [10, 10]]
		 ********************************************************************************/

		lngIncSbs = new int[n + 1]; // Longest Increasing Subsequence

		for (int i = 0; i < n; i++) {
			lngIncSbs[i] = 1;

			for (int j = 0; j < i; j++) {
				if (elcPl.get(i)[1] > elcPl.get(j)[1])
					lngIncSbs[i] = Math.max(lngIncSbs[i], lngIncSbs[j] + 1);
			}
		}

		/**************************************************
		 * lngIncSbs : [1, 1, 2, 1, 2, 3, 4, 5]
		 **************************************************/

		for (int i = 0; i < n; i++)
			elcWr = Math.max(elcWr, lngIncSbs[i]);

		elcWr = n - elcWr;

		System.out.println(elcWr);
	}

}
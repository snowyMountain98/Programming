import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		int[][] crd; /* 좌표 */

		n = scn.nextInt();

		crd = new int[n][2];

		for (int i = 0; i < n; i++) {
			crd[i][0] = scn.nextInt();
			crd[i][1] = scn.nextInt();
		}

		Arrays.sort(crd, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1])
					return Integer.compare(a[0], b[0]);
				else
					return Integer.compare(a[1], b[1]);
			}
		});

		for (int i = 0; i < n; i++)
			System.out.println(crd[i][0] + " " + crd[i][1]);

		scn.close();
	}

}
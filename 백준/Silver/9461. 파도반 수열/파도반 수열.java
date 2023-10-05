import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t, n;
		long[] p;

		t = scn.nextInt();
		p = new long[101];

		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;

		for (int i = 6; i <= 100; i++)
			p[i] = p[i - 1] + p[i - 5];

		while (t > 0) {
			n = scn.nextInt();

			System.out.println(p[n]);

			t--;
		}
	}

}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long a, b, c, d, e, f;

		a = scn.nextInt();
		b = scn.nextInt();
		c = scn.nextInt();
		d = scn.nextInt();
		e = scn.nextInt();
		f = scn.nextInt();

		LOOP:
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++)
				if (a * i + b * j == c && d * i + e * j == f) {
					System.out.println(i + " " + j);
					break LOOP;
				}
		}

		scn.close();
	}

}
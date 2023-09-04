import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t, a, b;
		int gcm, lcm = 0;

		t = scn.nextInt();

		while (t > 0) {
			a = scn.nextInt();
			b = scn.nextInt();

			gcm = Euclidean(a, b);

			lcm = a * b / gcm;

			System.out.println(lcm);

			t--;
		}
	}

	public static int Euclidean(int a, int b) {
		if (b == 0)
			return a;

		return Euclidean(b, a % b);
	}
}
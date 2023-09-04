import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long a, b;
		long gcm, lcm;

		a = scn.nextLong();
		b = scn.nextLong();

		gcm = Euclidean(a, b);

		lcm = a * b / gcm;

		System.out.println(lcm);
	}

	public static long Euclidean(long a, long b) {
		if (b == 0)
			return a;

		return Euclidean(b, a % b);
	}
}
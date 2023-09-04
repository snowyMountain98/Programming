import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a1, a2, b1, b2;
		int gcm, dnm, nmr;

		a1 = scn.nextInt();
		b1 = scn.nextInt();
		a2 = scn.nextInt();
		b2 = scn.nextInt();

		nmr = a1 * b2 + a2 * b1;	// 분모
		dnm = b1 * b2;				// 분자

		gcm = Euclidean(nmr, dnm);

		System.out.println((nmr / gcm) + " " + (dnm / gcm));
	}

	public static int Euclidean(int a, int b) {
		if (b == 0)
			return a;

		return Euclidean(b, a % b);
	}

}
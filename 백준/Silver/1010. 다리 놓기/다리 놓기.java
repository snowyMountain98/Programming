import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t, n, m;
		BigInteger nmr, dnm;

		t = scn.nextInt();

		while (t > 0) {
			n = scn.nextInt();
			m = scn.nextInt();

			n = Math.min(n, m - n);

			nmr = new BigInteger("1");
			dnm = new BigInteger("1");

			for (int i = m, j = n; j > 0; i--, j--) {
				nmr = nmr.multiply(BigInteger.valueOf(i));
				dnm = dnm.multiply(BigInteger.valueOf(j));
			}

			System.out.println(nmr.divide(dnm));

			t--;
		}
	}

}
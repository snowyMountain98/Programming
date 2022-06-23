import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder a, b;
		int A, B;

		a = new StringBuilder(sc.next());
		b = new StringBuilder(sc.next());

		// 거꾸로
		a = a.reverse();
		b = b.reverse();

		A = Integer.parseInt(a.toString());
		B = Integer.parseInt(b.toString());

		System.out.println(A > B ? A : B);
	}

}
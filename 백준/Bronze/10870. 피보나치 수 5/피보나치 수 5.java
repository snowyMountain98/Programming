import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;

		n = scn.nextInt();

		System.out.println(fibonacci(n));
	}

	public static int fibonacci(int n) {
		if (n == 0 || n == 1)
			return n;

		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
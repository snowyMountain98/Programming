import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long n;

		n = scn.nextLong();

		System.out.println(factorial(n));
	}

	public static Long factorial(Long n) {
		if (n <= 1)
			return (long) 1;

		return n * factorial(n - 1);
	}
}
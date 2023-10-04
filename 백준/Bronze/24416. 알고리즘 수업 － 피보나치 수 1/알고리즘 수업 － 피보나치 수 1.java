import java.util.Scanner;

public class Main {
	static int run1, run2;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;

		n = scn.nextInt();

		fib(n);
		fibonacci(n);

		System.out.print(run1 + " " + run2);
	}

	public static int fib(int n) {
		if (n == 1 || n == 2) {
			run1++;
			return 1;	// 코드1
		} else
			return (fib(n - 1) + fib(n - 2));
	}

	public static int fibonacci(int n) {
		int[] f = new int[n + 1];

		f[1] = f[2] = 1;

		for (int i = 3; i <= n; i++) {
			run2++;
			f[i] = f[i - 1] + f[i - 2];	// 코드2
		}

		return f[n];
	}
}
import java.util.Scanner;

public class Main {
	static int[] a, operator;
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		n = scn.nextInt();

		a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scn.nextInt();

		operator = new int[4];
		for (int i = 0; i < 4; i++)
			operator[i] = scn.nextInt();

		if (a.length > 1)
			insertOperator(a[0], 1);

		System.out.println(max + "\n" + min);
	}

	public static void insertOperator(int result, int index) {
		if (index >= n) {
			if (max < result)
				max = result;
			if (min > result)
				min = result;

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0)
				continue;

			operator[i] -= 1;

			switch (i) {
			case 0:
				insertOperator(result + a[index], index + 1);
				break;
			case 1:
				insertOperator(result - a[index], index + 1);
				break;
			case 2:
				insertOperator(result * a[index], index + 1);
				break;
			case 3:
				insertOperator(result / a[index], index + 1);
				break;
			}

			operator[i] += 1;
		}
	}
}
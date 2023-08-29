import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, answer = -1;

		n = scn.nextInt();

		LOOP:
		for (int i = n / 5; i >= 0; i--) {
			for (int j = 0; j <= (n - i * 5) / 3; j++)
				if (i * 5 + j * 3 == n) {
					answer = i + j;
					break LOOP;
				}
		}

		System.out.println(answer);

		scn.close();
	}

}
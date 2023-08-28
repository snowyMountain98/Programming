import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int answer = 0;

		int n = scn.nextInt();

		for (int i = 1; i < n; i++) {
			int gen = i;	// 생성자
			int dcm = gen;	// 분해합

			while (gen > 0) {
				dcm += gen % 10;
				gen /= 10;
			}

			if (dcm == n) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);

		scn.close();
	}

}
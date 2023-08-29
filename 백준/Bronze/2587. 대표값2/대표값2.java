import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] num = new int[5];
		int avg = 0, mdn;

		for (int i = 0; i < 5; i++)
			num[i] = scn.nextInt();

		/* 평균 */
		for (int i = 0; i < 5; i++)
			avg += num[i];
		avg /= 5;

		/* 중앙값 */
		Arrays.sort(num);
		mdn = num[2];

		System.out.println(avg);
		System.out.println(mdn);

		scn.close();
	}

}
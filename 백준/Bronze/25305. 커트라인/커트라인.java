import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, k;
		int[] score;

		n = scn.nextInt();
		k = scn.nextInt();

		score = new int[n];
		for (int i = 0; i < n; i++)
			score[i] = scn.nextInt();

		Arrays.sort(score);

		System.out.println(score[n - k]);

		scn.close();
	}

}
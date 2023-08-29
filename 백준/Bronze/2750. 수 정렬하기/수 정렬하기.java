import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		int[] arr;

		n = scn.nextInt();

		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		Arrays.sort(arr);

		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);

		scn.close();
	}

}
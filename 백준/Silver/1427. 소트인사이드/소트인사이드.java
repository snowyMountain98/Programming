import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String n;
		int[] arr;

		n = scn.next();

		arr = new int[n.length()];
		for (int i = 0; i < n.length(); i++)
			arr[i] = n.charAt(i) - '0';

		Arrays.sort(arr);

		for (int i = arr.length - 1; i >= 0; i--)
			System.out.print(arr[i]);

		scn.close();
	}

}
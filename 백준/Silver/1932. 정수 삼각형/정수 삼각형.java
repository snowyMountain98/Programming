import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		List<int[]> list = new ArrayList<>();
		List<int[]> max = new ArrayList<>();
		int n;

		n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			int[] arr = new int[i];

			for (int j = 0; j < i; j++)
				arr[j] = scn.nextInt();

			list.add(arr);
			max.add(arr);
		}

		for (int i = 0; i < n; i++)
			max.get(n - 1)[i] = list.get(n - 1)[i];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < list.get(i).length; j++)
				max.get(i)[j] = Math.max(max.get(i + 1)[j], max.get(i + 1)[j + 1]) + list.get(i)[j];
		}

		/******************************
		 * max :
		 * [30]
		 * [23, 21]
		 * [20, 13, 10]
		 * [ 7, 12, 10, 10]
		 * [ 4,  5,  2,  6, 5]
		 ******************************/
		
		System.out.println(max.get(0)[0]);
	}

}
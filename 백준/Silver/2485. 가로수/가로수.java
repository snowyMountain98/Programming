import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, gcm = 0, num = 0;
		int[] tree;

		n = scn.nextInt();

		tree = new int[n];
		for (int i = 0; i < n; i++)
			tree[i] = scn.nextInt();

		Arrays.sort(tree);

		/* 간격 */
		gcm = Euclidean(tree[2] - tree[1], tree[1] - tree[0]);
		for (int i = 2; i < n - 1; i++)
			gcm = Euclidean(tree[i + 1] - tree[i], gcm);

		for (int i = 0; i < n - 1; i++)
			num += ((tree[i + 1] - tree[i]) / gcm) - 1;

		System.out.println(num);
	}

	public static int Euclidean(int a, int b) {
		if (b == 0)
			return a;

		return Euclidean(b, a % b);
	}

}
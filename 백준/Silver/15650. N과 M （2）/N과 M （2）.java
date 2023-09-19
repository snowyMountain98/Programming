import java.util.Scanner;

public class Main {
	static boolean[] checked;
	static int[] seq;
	static int n, m;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		n = scn.nextInt();
		m = scn.nextInt();

		checked = new boolean[n + 1];
		seq = new int[m];

		backtracking(0, 1);
	}

	public static void backtracking(int index, int num) {
		if (index >= m) {
			for (int i = 0; i < m; i++)
				System.out.print(seq[i] + " ");
			System.out.println();

			return;
		}

		for (int i = num; i <= n; i++) {
			if (!checked[i]) {
				checked[i] = true;

				seq[index] = i;
				backtracking(index + 1, i);

				checked[i] = false;
			}
		}
	}
}
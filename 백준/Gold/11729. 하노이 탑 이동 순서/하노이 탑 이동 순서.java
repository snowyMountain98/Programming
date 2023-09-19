import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int k;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;

		n = scn.nextInt();

		hanoiTower(n, 1, 2, 3);

		sb.insert(0, k + "\n");

		System.out.println(sb.toString());
	}

	public static void hanoiTower(int disk, int from, int by, int to) {
		k++;

		if (disk == 1)
			sb.append(from + " " + to + "\n");
		else {
			hanoiTower(disk - 1, from, to, by);
			sb.append(from + " " + to + "\n");
			hanoiTower(disk - 1, by, from, to);
		}
	}
}
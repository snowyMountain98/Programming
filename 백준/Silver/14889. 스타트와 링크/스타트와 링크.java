import java.util.Scanner;

public class Main {
	static boolean[] team;
	static int[][] s;
	static int n, start, link, diff = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		n = scn.nextInt();

		s = new int[n][n];
		team = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				s[i][j] = scn.nextInt();
		}

		for (int i = 0; i < n; i++) {
			team[i] = true;
			startLink(i, 1);
			team[i] = false;
		}

		System.out.println(diff);
	}

	public static void startLink(int now, int depth) {
		if (depth == n / 2) {
			start = 0;
			link = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (team[i] && team[j])
						start += s[i][j] + s[j][i];

					if (!(team[i] || team[j]))
						link += s[i][j] + s[j][i];
				}
			}

			if (diff > Math.abs(start - link))
				diff = Math.abs(start - link);

			return;
		}

		for (int i = now + 1; i < n; i++) {
			team[i] = true;
			startLink(i, depth + 1);
			team[i] = false;
		}
	}
}
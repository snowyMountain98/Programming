import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, m;
		int[] card;
		int max = 0;

		n = scn.nextInt();
		m = scn.nextInt();
		card = new int[n];

		for (int i = 0; i < n; i++)
			card[i] = scn.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++)
				for (int k = j + 1; k < n; k++)
					if (card[i] + card[j] + card[k] <= m && max < card[i] + card[j] + card[k])
						max = card[i] + card[j] + card[k];
		}

		System.out.println(max);

		scn.close();
	}

}
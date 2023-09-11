import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Deque<int[]> dq = new ArrayDeque<>();
		String num = new String();
		int n, k;

		n = scn.nextInt();

		for (int i = 0; i < n; i++)
			dq.offer(new int[] { i + 1, scn.nextInt() });

		k = 1;

		while (!dq.isEmpty()) {
			int[] balloon = new int[2];

			if (k > 0) {
				for (int i = 0; i < (k - 1); i++)
					dq.offerLast(dq.pollFirst());

				balloon = dq.pollFirst();
			} else {
				for (int i = 0; i < (Math.abs(k) - 1); i++)
					dq.offerFirst(dq.pollLast());

				balloon = dq.pollLast();
			}

			num += Integer.toString(balloon[0]) + " ";
			k = balloon[1];
		}

		System.out.println(num);
	}

}
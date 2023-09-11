import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Queue<Integer> Q = new LinkedList<>();
		List<Integer> josephus = new ArrayList<>();
		int n, k;

		n = scn.nextInt();
		k = scn.nextInt();

		for (int i = 1; i <= n; i++)
			Q.add(i);

		while (Q.size() > 0) {
			for (int i = 0; i < (k - 1) % Q.size(); i++)
				Q.offer(Q.poll());

			josephus.add(Q.poll());

			/********************************************************************************
			 * Q : [4, 5, 6, 7, 1, 2] → [7, 1, 2, 4, 5] → [4, 5, 7, 1] → [1, 4, 5] → [1, 4]
			 * → [4] → []
			 ********************************************************************************/
		}

		System.out.println(josephus.toString().replace("[", "<").replace("]", ">"));
	}

}
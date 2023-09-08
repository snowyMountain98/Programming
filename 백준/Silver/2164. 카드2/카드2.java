import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Queue<Integer> Q = new LinkedList<>();
		int n;

		n = scn.nextInt();

		for (int i = 1; i <= n; i++)
			Q.offer(i);

		while (Q.size() > 1) {
			Q.poll();
			Q.offer(Q.poll());
		}

		/********************************************************************************
		 * Q : [1, 2, 3, 4, 5, 6] → [3, 4, 5, 6, 2] → [5, 6, 2, 4] → [2, 4, 6] → [6, 4]
		 * → [4]
		 ********************************************************************************/

		System.out.println(Q.poll());
	}

}
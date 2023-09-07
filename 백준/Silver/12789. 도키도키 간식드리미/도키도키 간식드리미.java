import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();	// 현재 줄 서있는 곳
		Stack<Integer> stack = new Stack<>();		// 한 명씩만 설 수 있는 공간
		int n, order;

		n = scn.nextInt();

		for (int i = 0; i < n; i++)
			queue.add(scn.nextInt());

		order = 1;
		while (!queue.isEmpty()) {
			if (queue.peek() != order) {
				stack.push(queue.poll());
			} else {
				queue.poll();
				order++;
			}

			while (!stack.isEmpty() && stack.peek() == order) {
				stack.pop();
				order++;
			}
		}

		if (queue.isEmpty() && stack.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}

}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] board;
	static int n, cnt;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		n = scn.nextInt();

		board = new int[n];

		n_Queens(0);
		
		/******************************
		 * board : [1, 3, 0, 2]
		 * ┌───┬───┬───┬───┐
		 * │ X │ O │ X │ X │
		 * ├───┼───┼───┼───┤
		 * │ X │ X │ X │ O │
		 * ├───┼───┼───┼───┤
		 * │ O │ X │ X │ X │
		 * ├───┼───┼───┼───┤
		 * │ X │ X │ O │ X │
		 * └───┴───┴───┴───┘
		 ******************************/

		System.out.println(cnt);
	}

	public static void n_Queens(int index) {
		if (index == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			board[index] = i;

			if (promising(index))
				n_Queens(index + 1);
		}
	}

	public static boolean promising(int index) {
		for (int i = 0; i < index; i++) {
			if (board[index] == board[i] || Math.abs(board[index] - board[i]) == (index - i))
				return false;
		}

		return true;
	}
}
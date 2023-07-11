import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[][] board) {
		int answer = 0;
		Queue<int[]> Q = new LinkedList<>();
		int[] dx = { 1, 1, 1, 0, -1, -1, -1, 0 };
		int[] dy = { 1, 0, -1, -1, -1, 0, 1, 1 };
		int[] bomb;
		int nx, ny;

		/********************
		 * board :
		 * [0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0]
		 * [0, 0, 1, 1, 0]
		 * [0, 0, 0, 0, 0]
		 ********************/

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				if (board[i][j] == 1)
					Q.add(new int[] { j, i });
		}

		/* q : [[2, 3][3, 3]] */

		while (!Q.isEmpty()) {
			bomb = Q.poll();

			for (int i = 0; i < dx.length; i++) {
				nx = bomb[0] + dx[i];
				ny = bomb[1] + dy[i];

				if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length)
					board[ny][nx] = 1;
			}
		}

		/********************
		 * board :
		 * [0, 0, 0, 0, 0]
		 * [0, 0, 0, 0, 0]
		 * [0, 1, 1, 1, 1]
		 * [0, 1, 1, 1, 1]
		 * [0, 1, 1, 1, 1]
		 ********************/

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++)
				if (board[i][j] == 0)
					answer++;
		}

		return answer;
	}
}
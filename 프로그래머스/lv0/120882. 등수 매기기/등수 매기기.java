import java.util.Arrays;
import java.util.Collections;

class Solution {
	public static int[] solution(int[][] score) {
		int[] answer = new int[score.length];
		Integer[] avg = new Integer[score.length];

		for (int i = 0; i < score.length; i++)
			avg[i] = score[i][0] + score[i][1];

		Arrays.sort(avg, Collections.reverseOrder());

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < avg.length; j++)
				if (score[i][0] + score[i][1] == avg[j]) {
					answer[i] = j + 1;
					break;
				}
		}

		return answer;
	}
}
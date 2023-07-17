import java.util.Arrays;
import java.util.Collections;

class Solution {
	public int[] solution(int[][] score) {
		int[] answer = new int[score.length];
		Double[] avg = new Double[score.length];

		for (int i = 0; i < score.length; i++)
			avg[i] = ((double) score[i][0] + score[i][1]) / 2;

		Arrays.sort(avg, Collections.reverseOrder());

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < avg.length; j++)
				if ((double) (score[i][0] + score[i][1]) / 2 == avg[j]) {
					answer[i] = j + 1;
					break;
				}
		}

		return answer;
	}
}
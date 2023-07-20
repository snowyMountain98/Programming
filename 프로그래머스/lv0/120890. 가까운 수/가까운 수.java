import java.util.Arrays;

class Solution {
	public int solution(int[] array, int n) {
		int answer = 0, diff = Integer.MAX_VALUE;

		Arrays.sort(array);

		for (int i = array.length - 1; i >= 0; i--) {
			if (diff >= Math.abs(n - array[i])) {
				diff = Math.abs(n - array[i]);
				answer = array[i];
			} else
				break;
		}

		return answer;
	}
}
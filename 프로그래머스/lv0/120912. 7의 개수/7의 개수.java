class Solution {
	public int solution(int[] array) {
		int answer = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < Integer.toString(array[i]).length(); j++)
				if ('7' == Integer.toString(array[i]).charAt(j))
					answer++;
		}

		return answer;
	}
}
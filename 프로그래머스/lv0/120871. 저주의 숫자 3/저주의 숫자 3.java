class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			do {
				answer++;
			} while (answer % 3 == 0 || Integer.toString(answer).contains("3"));
		}

		return answer;
	}
}
class Solution {
	public int solution(String A, String B) {
		int answer = 0;

		while (answer < A.length()) {
			if (B.equals(A))
				return answer;

			A = A.substring(A.length() - 1, A.length()) + A.substring(0, A.length() - 1);
			answer++;
		}

		return -1;
	}
}
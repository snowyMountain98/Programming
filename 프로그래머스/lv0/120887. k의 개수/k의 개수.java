class Solution {
	public int solution(int i, int j, int k) {
		int answer = 0;

		for (int num = i; num <= j; num++) {
			char[] ch = Integer.toString(num).toCharArray();

			for (int c = 0; c < ch.length; c++) {
				if (ch[c] == Character.forDigit(k, 10))
					answer++;
			}
		}

		return answer;
	}
}
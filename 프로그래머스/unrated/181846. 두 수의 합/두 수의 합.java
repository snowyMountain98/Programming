class Solution {
	public String solution(String a, String b) {
		String answer = "";
		int max = Math.max(a.length(), b.length());
		int A, B, temp = 0;

		while (a.length() < max)
			a = '0' + a;

		while (b.length() < max)
			b = '0' + b;

		/****************************************
		 * a : 018446744073709551615
		 * b : 287346502836570928366
		 ****************************************/

		for (int i = a.length() - 1; i >= 0; i--) {
			A = a.charAt(i) - '0';
			B = b.charAt(i) - '0';

			answer = Integer.toString((A + B + temp) % 10) + answer;
			temp = (A + B + temp) / 10;
		}

		if (temp != 0)
			answer = Integer.toString(temp) + answer;

		return answer;
	}
}
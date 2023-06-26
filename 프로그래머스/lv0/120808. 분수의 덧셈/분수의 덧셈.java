class Solution {
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];

		/******************************
		 * a   c   (a * d) + (c * b)
		 * ─ + ─ = ─────────────────
		 * b   d         b * d
		 ******************************/

		int numer3 = numer1 * denom2 + numer2 * denom1;
		int denom3 = denom1 * denom2;

		int gcd = gcd(numer3, denom3);

		answer[0] = numer3 / gcd;
		answer[1] = denom3 / gcd;

		return answer;
	}

	public int gcd(int a, int b) {
		if (b > a)
			return gcd(b, a);

		if (a % b == 0)
			return b;

		return gcd(b, a % b);
	}
}
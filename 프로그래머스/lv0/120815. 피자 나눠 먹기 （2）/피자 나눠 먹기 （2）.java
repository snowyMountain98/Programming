class Solution {
	public int solution(int n) {
		int pieces = n * 6 / gcd(n, 6);

		return pieces / 6;
	}

	public int gcd(int a, int b) {
		if (b > a)
			return gcd(b, a);

		if (a % b == 0)
			return b;

		return gcd(b, a % b);
	}
}
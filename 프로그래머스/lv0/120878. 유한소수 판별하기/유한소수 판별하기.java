class Solution {
	public int solution(int a, int b) {
		int gcd = gcd(b, a);

		a /= gcd;
		b /= gcd;

		while (b % 2 == 0 || b % 5 == 0) {
			if (b % 2 == 0)
				b /= 2;
			else if (b % 5 == 0)
				b /= 5;
		}

		if (b != 1)
			return 2;
		else
			return 1;
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}
}
class Solution {
	public int solution(int n) {
        /******************************
         *             ∣ab∣
         * lcm(a,b)= ────────
         *           gcd(a,b)
         ******************************/
        
		return n * 6 / gcd(n, 6) / 6;
	}

	public int gcd(int a, int b) {
		if (b > a)
			return gcd(b, a);

		if (a % b == 0)
			return b;

		return gcd(b, a % b);
	}
}
class Solution {
	public int solution(int balls, int share) {
		return C(balls, share);
	}

    
	public int C(int n, int r) {
		/********************
		 * nC0 = 1, nCn = 1
		 ********************/
		if (n == r || r == 0)
			return 1;

		/********************
		 * nC1 = n
		 ********************/
		if (r == 1)
			return n;

		/****************************************
		 * nCr = n-1Cr-1 + n-1Cr (0 <= r <= n)
		 ****************************************/
		return C(n - 1, r - 1) + C(n - 1, r);
	}
}
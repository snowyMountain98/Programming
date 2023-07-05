class Solution {
	public static int solution(int balls, int share) {
		long dnm = 1, nmr = 1;

		/* nCr = nC(n-r) */
		if (share > balls - share)
			share = balls - share;

		if (share == 0)
			return 1;

		for (int i = 1, j = balls; i <= share; i++, j--) {
			nmr *= j; // 분자
			dnm *= i; // 분모

            /* 약분 */
			if (nmr % dnm == 0) {
				nmr /= dnm;
				dnm = 1;
			}
		}

		return (int) (nmr / dnm);
	}
}
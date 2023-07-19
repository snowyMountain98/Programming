class Solution {
	public int solution(String before, String after) {
		int[] bfr = new int[26];
		int[] aft = new int[26];

		for (int i = 0; i < before.length(); i++) {
			bfr[before.charAt(i) - 97]++;
			aft[after.charAt(i) - 97]++;
		}

		for (int i = 0; i < bfr.length; i++) {
			if (bfr[i] != aft[i])
				return 0;
		}

		return 1;
	}
}
class Solution {
	public int solution(int[] date1, int[] date2) {
		int d1 = Integer.parseInt(Integer.toString(date1[0]) + Integer.toString(date1[1]) + Integer.toString(date1[2]));
		int d2 = Integer.parseInt(Integer.toString(date2[0]) + Integer.toString(date2[1]) + Integer.toString(date2[2]));

		if (d1 < d2)
			return 1;

		return 0;
	}
}
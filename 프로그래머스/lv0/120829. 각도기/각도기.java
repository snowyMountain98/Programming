class Solution {
	public int solution(int angle) {
		if (angle == 180)		// 평각
			return 4;
		else if (angle > 90)	// 둔각
			return 3;
		else if (angle == 90)	// 직각
			return 2;
		else					// 예각
			return 1;
	}
}
class Solution {
	public int solution(int n) {
		if (Math.pow((int) Math.sqrt(n), 2) == n)
			return 1;
		else
			return 2;
	}
}
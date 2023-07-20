class Solution {
	public int solution(int order) {
		return Integer.toString(order).length() - Integer.toString(order).replaceAll("3|6|9", "").length();
	}
}
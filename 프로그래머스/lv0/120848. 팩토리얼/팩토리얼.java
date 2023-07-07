class Solution {
	public int solution(int n) {
		int i = 0, fct = 1;

		do {
			i++;
			fct *= i;
		} while (fct * (i + 1) <= n);

		return i;
	}
}
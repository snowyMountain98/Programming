import java.util.Arrays;

class Solution {
	public String solution(String my_string) {
		char[] lwr = my_string.toLowerCase().toCharArray();
		Arrays.sort(lwr);

		return new String(lwr);
	}
}
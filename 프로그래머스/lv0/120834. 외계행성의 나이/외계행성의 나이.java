class Solution {
	public String solution(int age) {
		String answer = "";
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };

		for (int i = 0; i < Integer.toString(age).length(); i++) {
			answer += alphabet[Character.getNumericValue(Integer.toString(age).charAt(i))];
		}

		return answer;
	}
}
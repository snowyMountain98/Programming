import java.util.HashSet;
import java.util.Set;

class Solution {
	public String solution(String my_string) {
		String answer = "";
		Set<Character> letter = new HashSet<>();

		for (int i = 0; i < my_string.length(); i++) {
			if (!letter.contains(my_string.charAt(i))) {
				letter.add(my_string.charAt(i));
				answer += my_string.charAt(i);
			}
		}

		// letter : [p, e, l, o]

		return answer;
	}
}
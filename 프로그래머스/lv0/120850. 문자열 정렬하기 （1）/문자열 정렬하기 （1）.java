import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
	public int[] solution(String my_string) {
		int[] answer = {};

		my_string = my_string.replaceAll("[a-z]", "");
		answer = Stream.of(my_string.split("")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(answer);

		return answer;
	}
}
import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int n, int[] numlist) {
		int[] answer = {};
		List<Integer> multiple = new ArrayList<>();

		for (int i = 0; i < numlist.length; i++) {
			if (numlist[i] % n == 0)
				multiple.add(numlist[i]);
		}

		answer = new int[multiple.size()];
		for (int i = 0; i < multiple.size(); i++)
			answer[i] = multiple.get(i);

		return answer;
	}
}
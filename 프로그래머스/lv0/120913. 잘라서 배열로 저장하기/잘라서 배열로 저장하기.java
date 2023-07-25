import java.util.ArrayList;
import java.util.List;

class Solution {
	public String[] solution(String my_str, int n) {
		String[] answer;
		List<String> my_lst = new ArrayList<>();

		for (int i = 0; i < my_str.length(); i += n) {
			if (i + n <= my_str.length())
				my_lst.add(my_str.substring(i, i + n));
			else
				my_lst.add(my_str.substring(i));
		}

		answer = new String[my_lst.size()];
		for (int i = 0; i < my_lst.size(); i++)
			answer[i] = my_lst.get(i);

		return answer;
	}
}
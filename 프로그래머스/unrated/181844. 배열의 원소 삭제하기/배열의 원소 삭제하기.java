import java.util.ArrayList;

class Solution {
	public int[] solution(int[] arr, int[] delete_list) {
		int[] answer = {};
		ArrayList<Integer> ary = new ArrayList<>();

		for (int i = 0; i < arr.length; i++)
			ary.add(arr[i]);

		for (int i = 0; i < delete_list.length; i++) {
			if (ary.contains(delete_list[i]))
				ary.remove(ary.indexOf(delete_list[i]));
        }

		answer = new int[ary.size()];
		for (int i = 0; i < ary.size(); i++)
			answer[i] = ary.get(i);

		return answer;
	}
}
import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int[] solution(int[] emergency) {
		int[] answer = new int[emergency.length];
		int[] order = emergency.clone();
		HashMap<Integer, Integer> map = new HashMap<>();

		/**************************************************
		 * order : [6, 10, 23, 30, 100]
		 **************************************************/
		Arrays.sort(order);

		/**************************************************
		 * map : {100=1, 6=5, 23=3, 10=4, 30=2}
		 **************************************************/
		for (int i = 0; i < order.length; i++)
			map.put(order[i], order.length - i);

		/**************************************************
		 * answer : [2, 4, 3, 5, 1]
		 **************************************************/
		for (int i = 0; i < emergency.length; i++)
			answer[i] = map.get(emergency[i]);

		return answer;
	}
}
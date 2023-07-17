import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int[] numlist, int n) {
		int[] answer = new int[numlist.length];
		List<Integer> ls = new ArrayList<>();

		/******************************
		 *   [1]
		 * → [2, 1]
		 * → [3, 2, 1]
		 * → [4, 3, 2, 1]
		 * → [4, 5, 3, 2, 1]
		 * → [4, 5, 3, 6, 2, 1]
		 *******************************/

		ls.add(numlist[0]);

		LOOP:
		for (int i = 1; i < numlist.length; i++) {
			for (int j = 0; j < ls.size(); j++) {
				/* n과 가까운 수부터 정렬 */
				if (Math.abs(n - numlist[i]) < Math.abs(n - ls.get(j))) {
					ls.add(j, numlist[i]);

					continue LOOP;
				}
				/* n으로부터의 거리가 같다면 */
				else if (Math.abs(n - numlist[i]) == Math.abs(n - ls.get(j))) {
					/* 더 큰 수를 앞에 오도록 배치 */
					if (numlist[i] > ls.get(j))
						ls.add(j, numlist[i]);
					else
						ls.add(j + 1, numlist[i]);

					continue LOOP;
				}
			}
			ls.add(numlist[i]);
		}

		for (int i = 0; i < ls.size(); i++)
			answer[i] = ls.get(i);

		return answer;
	}
}
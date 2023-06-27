import java.util.HashMap;

class Solution {
	public int solution(int[] array) {
		int answer = 0, max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++)
			map.put(array[i], map.getOrDefault(array[i], 0) + 1);

		for (int key : map.keySet()) {
			if (max < map.get(key)) {
				max = map.get(key);
				answer = key;
			}
            /* 최빈값이 여러 개면 -1 */
            else if (max == map.get(key)) {
				max = map.get(key);
				answer = -1;
			}
		}

		return answer;
	}
}
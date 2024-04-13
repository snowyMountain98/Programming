import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		Map<String, Integer> idx = new HashMap<>();
		List<int[]> lst = new ArrayList<>();
		int[][] answer = {};

		idx.put("code", 0);
		idx.put("date", 1);
		idx.put("maximum", 2);
		idx.put("remain", 3);

		for (int i = 0; i < data.length; i++) {
			/* ext 값이 val_ext보다 작은 데이터만 뽑 */
			if (data[i][idx.get(ext)] < val_ext)
				lst.add(data[i]);
		}

		/* sort_by에 해당하는 값을 기준으로 오름차순으로 정렬 */
		Collections.sort(lst, new Comparator<int[]>() {
			public int compare(int[] s1, int[] s2) {
				if (s1[idx.get(sort_by)] < s2[idx.get(sort_by)])
					return -1;
				else if (s1[idx.get(sort_by)] > s2[idx.get(sort_by)])
					return 1;
				else
					return 0;
			}
		});

        answer = new int[lst.size()][4];
		for (int i = 0; i < lst.size(); i++)
			answer[i] = lst.get(i);

		return answer;
	}
}
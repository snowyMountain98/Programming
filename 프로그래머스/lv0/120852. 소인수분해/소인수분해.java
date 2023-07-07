import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] solution(int n) {
		List<Integer> answer = new ArrayList<>();
		boolean[] prime = new boolean[n + 1];

		for (int i = 1; i <= n; i++)
			prime[i] = true;

		for (int i = 2; i <= n; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;

				if (n % i == 0)
					answer.add(i);
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
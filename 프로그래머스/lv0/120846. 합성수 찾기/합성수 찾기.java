class Solution {
	public static int solution(int n) {
		int answer = 0;
		boolean[] prime = new boolean[n + 1];

		for (int i = 2; i <= n; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		}

		/* prime : [1:false, 2:true, 3:true, 4:false, 5:true, 6:false, 7:true, 8:false, 9:false, 10:false] */

		for (int i = 2; i <= n; i++) {
			if (!prime[i])
				answer++;
		}

		return answer;
	}
}
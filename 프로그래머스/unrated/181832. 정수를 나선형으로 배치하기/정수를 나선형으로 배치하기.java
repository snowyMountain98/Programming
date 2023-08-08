class Solution {
	public int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int num = 1;

		for (int k = 0; k <= n / 2; k++) {
			for (int i = k; i < n - k; i++, num++)
				answer[k][i] = num;

			for (int i = k + 1; i < n - k; i++, num++)
				answer[i][n - k - 1] = num;

			for (int i = n - k - 2; i >= k; i--, num++)
				answer[n - k - 1][i] = num;

			for (int i = n - k - 2; i > k; i--, num++)
				answer[i][k] = num;

			if (num > n * n)
				break;
		}

		return answer;
	}
}
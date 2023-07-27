class Solution {
	public int[] solution(int num, int total) {
		int[] answer = new int[num];
		int min = (2 * total - num * num + num) / (2 * num);
        
		/****************************************
		 *             num(num - 1)
		 * min * num + ──────────── = total
		 *                   2
		 ****************************************/        

		for (int i = 0; i < num; i++)
			answer[i] = min + i;

		return answer;
	}
}
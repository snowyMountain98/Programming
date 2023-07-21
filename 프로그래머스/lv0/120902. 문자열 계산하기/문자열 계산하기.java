class Solution {
	public int solution(String my_string) {
		int answer = 0;
		String[] nExpr = my_string.split(" ");

		// nExpr : [3, +, 4]

		answer += Integer.parseInt(nExpr[0]);

		for (int i = 1; i < nExpr.length - 1; i++) {
			if (nExpr[i].equals("+"))
				answer += Integer.parseInt(nExpr[i + 1]);
			else if (nExpr[i].equals("-"))
				answer -= Integer.parseInt(nExpr[i + 1]);
		}

		return answer;
	}
}
class Solution {
	public static String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];

		for (int i = 0; i < quiz.length; i++) {
			String[] nExpr = quiz[i].split(" ");

			// nExpr : [3, -, 4, =, -3]

			switch (nExpr[1]) {
			case "+":
				answer[i] = Integer.parseInt(nExpr[0]) + Integer.parseInt(nExpr[2]) == Integer.parseInt(nExpr[4]) ? "O" : "X";
				break;
			case "-":
				answer[i] = Integer.parseInt(nExpr[0]) - Integer.parseInt(nExpr[2]) == Integer.parseInt(nExpr[4]) ? "O" : "X";
				break;
			}
		}

		return answer;
	}
}
class Solution {
	public int solution(String[] order) {
		int answer = 0;

		for (int i = 0; i < order.length; i++) {
			switch (order[i].replaceAll("ice|hot", "")) {
			case "americano":
				answer += 4500;
				break;
			case "cafelatte":
				answer += 5000;
				break;
			default:
				answer += 4500;
				break;
			}
		}

		return answer;
	}
}
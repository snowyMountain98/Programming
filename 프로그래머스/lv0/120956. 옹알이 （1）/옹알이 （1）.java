class Solution {
	public int solution(String[] babbling) {
		int answer = 0;

		LOOP:
		for (int i = 0; i < babbling.length; i++) {
			babbling[i] = babbling[i].replaceAll("aya", " ");
			babbling[i] = babbling[i].replaceAll("ye", " ");
			babbling[i] = babbling[i].replaceAll("woo", " ");
			babbling[i] = babbling[i].replaceAll("ma", " ");

			for (int j = 0; j < babbling[i].length(); j++) {
				if (babbling[i].charAt(j) != ' ')
					continue LOOP;
			}

			answer++;
		}

		return answer;
	}
}
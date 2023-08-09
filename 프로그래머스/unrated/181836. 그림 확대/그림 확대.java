class Solution {
	public String[] solution(String[] picture, int k) {
		String[] answer = new String[picture.length * k];
		int f = 0;

		for (int g = 0; g < picture.length; g++) {
			for (int h = 0; h < k; h++) {
				String str = "";
				
				for (int i = 0; i < picture[g].length(); i++) {
					for (int j = 0; j < k; j++)
						str += picture[g].charAt(i);
				}
				
				answer[f++] = str;
			}
		}

		return answer;
	}
}
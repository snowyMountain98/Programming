class Solution {
	public int solution(String my_string) {
		int answer = 0;
		String[] num = my_string.split("[a-zA-Z]+");
		
		/******************************
		 * my_string : aAb1B2cC34oOp
		 * num : [, 1, 2, 34]
		 ******************************/

		for (int i = 0; i < num.length; i++) {
			answer += Integer.parseInt(num[i].equals("") ? "0" : num[i]);
		}

		return answer;
	}
}
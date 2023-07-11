class Solution {
	public int solution(String[] spell, String[] dic) {
		LOOP: 
		for (int i = 0; i < dic.length; i++) {
			for (int j = 0; j < spell.length; j++) {
				if (dic[i].contains(spell[j]))
					dic[i] = dic[i].replace(spell[j], "");
				else
					continue LOOP;
			}
			
			if (dic[i].length() == 0)
				return 1;
		}

		return 2;
	}
}
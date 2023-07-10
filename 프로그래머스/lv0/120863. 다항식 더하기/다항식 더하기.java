class Solution {
	public String solution(String polynomial) {
		String[] term = polynomial.split(" \\+ ");
		int lnrTrm = 0 /* 일차항 */, cnsTrm = 0; /* 상수항 */

		/* term : [3x, 7, x] */

		for (int i = 0; i < term.length; i++) {
			if (term[i].equals("x"))
				lnrTrm += 1;
			else if (term[i].charAt(term[i].length() - 1) == 'x')
				lnrTrm += Integer.parseInt(term[i].replace("x", ""));
			else
				cnsTrm += Integer.parseInt(term[i]);
		}

		if (lnrTrm == 0)
			return Integer.toString(cnsTrm);
		else if (cnsTrm == 0)
			return lnrTrm == 1 ? "x" : lnrTrm + "x";
		else
			return (lnrTrm == 1 ? "x" : lnrTrm + "x") + " + " + cnsTrm;
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		Set<String> prtStr = new HashSet<>();
		String s;

		s = scn.nextLine();

		for (int i = 0; i < s.length(); i++) {
			for (int j = 1; j + i <= s.length(); j++)
				prtStr.add(s.substring(i, i + j));
		}

		/************************************************************
		 * s: [a, ab, aba, bc, b, bab, abc, c, ababc, babc, abab, ba]
		 ************************************************************/

		System.out.println(prtStr.size());
	}

}
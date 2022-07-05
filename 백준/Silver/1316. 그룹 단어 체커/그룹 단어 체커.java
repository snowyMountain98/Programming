import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word;
		boolean[] alphb;
		boolean grpWrd;
		int n, num = 0;

		n = sc.nextInt();

		while (n > 0) {
			word = sc.next();

			alphb = new boolean[26];
			alphb[word.charAt(0) - 'a'] = true;
			grpWrd = true;

			for (int i = 1; i < word.length(); i++) {
				if (word.charAt(i) == word.charAt(i - 1))
					continue;

				if (alphb[word.charAt(i) - 'a']) {
					grpWrd = false;
					break;
				}

				alphb[word.charAt(i) - 'a'] = true;
			}

			if (grpWrd)
				num++;

			n--;
		}

		System.out.println(num);
	}

}
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word;
		int num = 0;
		// 크로아티아 알파벳
		List<String> crtnAlphb = Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

		word = sc.next();

		for (int i = 0; i < word.length(); i++) {
			if (i + 3 <= word.length() && crtnAlphb.contains(word.substring(i, i + 3))) {
				num++;
				i += 2;
			} else if (i + 2 <= word.length() && crtnAlphb.contains(word.substring(i, i + 2))) {
				num++;
				i += 1;
			} else {
				num++;
			}
		}

		System.out.println(num);
	}

}
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		int[] alphabet = new int[26];

		s = sc.next();

		for (int i = 0; i < 26; i++) {
			alphabet[i] = -1;
		}

		for (int i = 0; i < s.length(); i++) {
			if (alphabet[s.charAt(i) - 'a'] == -1)
				alphabet[s.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}

}
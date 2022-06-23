import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word;
		int[] alphb = new int[26];
		int max = 0;
		char mostUsed = '?';

		word = sc.next();
		word = word.toUpperCase();

		for (int i = 0; i < word.length(); i++) {
			alphb[word.charAt(i) - 'A'] += 1;
		}

		for (int i = 0; i < 26; i++) {
			if (max < alphb[i]) {
				max = alphb[i];
				mostUsed = (char) (i + 'A');
			}
			// 가장 많이 사용된 알파벳이 여러 개 존재하는 경우
			else if (max == alphb[i]) {
				mostUsed = '?';
			}
		}

		System.out.println(mostUsed);
	}

}
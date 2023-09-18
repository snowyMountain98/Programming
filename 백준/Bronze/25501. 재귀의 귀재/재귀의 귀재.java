import java.util.Scanner;

public class Main {
	static int call;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t;
		String s;

		t = scn.nextInt();

		while (t > 0) {
			s = scn.next();
			call = 0;

			System.out.println(isPalindrome(s) + " " + call);

			t--;
		}
	}

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	public static int recursion(String s, int l, int r) {
		call++;

		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}
}
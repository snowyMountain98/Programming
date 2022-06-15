import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		int t, r;
		StringBuilder p;

		t = sc.nextInt();

		while (t > 0) {
			r = sc.nextInt();
			s = sc.next();
			p = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < r; j++) {
					p.append(s.charAt(i));
				}
			}
			
			System.out.println(p);

			t--;
		}
	}

}
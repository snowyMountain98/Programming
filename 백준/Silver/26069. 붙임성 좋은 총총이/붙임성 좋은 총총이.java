import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Set<String> dance = new HashSet<>();
		int n;
		String A, B;

		n = scn.nextInt();

		dance.add("ChongChong");

		while (n > 0) {
			A = scn.next();
			B = scn.next();

			if (dance.contains(A))
				dance.add(B);
			else if (dance.contains(B))
				dance.add(A);

			n--;
		}

		System.out.println(dance.size());
	}

}
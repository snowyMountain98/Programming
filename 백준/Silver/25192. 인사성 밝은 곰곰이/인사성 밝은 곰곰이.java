import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Set<String> nickname = new HashSet<>();
		int n, gomgom = 0;

		n = scn.nextInt();

		while (n > 0) {
			String log = scn.next();

			if (!"ENTER".equals(log)) {
				nickname.add(log);
			} else {
				gomgom += nickname.size();
				nickname = new HashSet<>();
			}

			n--;
		}

		gomgom += nickname.size();

		System.out.println(gomgom);
	}

}
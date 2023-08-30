import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		Set<String> set = new HashSet<>();
		List<String> word;

		n = scn.nextInt();

		for (int i = 0; i < n; i++)
			set.add(scn.next());

		word = new ArrayList<>(set);

		Collections.sort(word, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length())
					return s1.compareTo(s2);
				else
					return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < word.size(); i++)
			System.out.println(word.get(i));

		scn.close();
	}

}
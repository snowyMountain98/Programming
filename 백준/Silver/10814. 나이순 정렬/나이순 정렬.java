import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n;
		String[][] member;

		n = scn.nextInt();

		member = new String[n][2];
		for (int i = 0; i < n; i++) {
			member[i][0] = scn.next();
			member[i][1] = scn.next();
		}

		Arrays.sort(member, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				return o1[0] == o2[0] ? o1[1].compareTo(o2[1]) : Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}

		});

		for (int i = 0; i < n; i++)
			System.out.println(member[i][0] + " " + member[i][1]);

		scn.close();
	}

}
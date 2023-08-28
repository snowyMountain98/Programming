import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n, theNmbOfEnd = 0;
		int i, num;

		n = scn.nextInt();

		i = 1; num = 0;
		while (true) {
			if (Integer.toString(i).contains("666")) {
				theNmbOfEnd = i;
				num++;
			}

			if (num == n)
				break;

			i++;
		}

		System.out.println(theNmbOfEnd);

		scn.close();
	}

}
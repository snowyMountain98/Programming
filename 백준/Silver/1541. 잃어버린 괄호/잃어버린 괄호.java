import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String formula;
		boolean minus = false;
		StringBuilder sb = new StringBuilder();
		int result = 0;

		formula = scn.nextLine();

		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) == '-') {
				minus = true;
				result += Integer.parseInt(sb.toString());
				sb = new StringBuilder();
			} else if (formula.charAt(i) == '+') {
				if (minus)
					formula = formula.substring(0, i) + '-' + formula.substring(i + 1);

				result += Integer.parseInt(sb.toString());
				sb = new StringBuilder();
			}
			
			sb.append(formula.charAt(i));
		}

		result += Integer.parseInt(sb.toString());

		System.out.println(result);
	}

}
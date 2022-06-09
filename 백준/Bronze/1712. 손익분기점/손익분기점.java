import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		int brkEvnPnt; // 손익분기점

		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		// a + bx < cx
		// a < (c - b)x
		// a / (c - b) < x

		if (c - b > 0)
			brkEvnPnt = a / (c - b) + 1;
		else
			brkEvnPnt = -1;

		System.out.println(brkEvnPnt);
	}

}
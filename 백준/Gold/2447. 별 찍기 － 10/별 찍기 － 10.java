import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static char[][] pattern;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;

		n = Integer.parseInt(br.readLine());

		pattern = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				pattern[i][j] = '*';
		}

		drawStar(0, n - 1, 0, n - 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				bw.write(pattern[i][j]);
			bw.write("\n");
		}

		bw.flush();
	}

	public static void drawStar(int o1, int r1, int o2, int r2) {
		int p1, q1, p2, q2;

		if (r1 - o1 < 2 || r2 - o2 < 2)
			return;

		p1 = (o1 * 2 + r1) / 3;
		q1 = (o1 + r1 * 2) / 3;
		p2 = (o2 * 2 + r2) / 3;
		q2 = (o2 + r2 * 2) / 3;

		for (int i = p1 + 1; i <= q1; i++) {
			for (int j = p2 + 1; j <= q2; j++)
				pattern[i][j] = ' ';
		}

		drawStar(o1, p1, o2, p2);
		drawStar(p1 + 1, q1, o2, p2);
		drawStar(q1 + 1, r1, o2, p2);
		drawStar(o1, p1, p2 + 1, q2);
		drawStar(q1 + 1, r1, p2 + 1, q2);
		drawStar(o1, p1, q2 + 1, r2);
		drawStar(p1 + 1, q1, q2 + 1, r2);
		drawStar(q1 + 1, r1, q2 + 1, r2);
	}
}
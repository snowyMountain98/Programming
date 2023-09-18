import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String n;

		while ((n = br.readLine()) != null) {
			s = new StringBuilder();

			for (int i = 0; i < Math.pow(3, Integer.parseInt(n)); i++)
				s.append("-");

			cantor(0, s.length() - 1);

			bw.write(s + "\n");
		}

		bw.flush();
	}

	public static void cantor(int o, int r) {
		int p, q;

		if (o >= r)
			return;

		p = (o * 2 + r) / 3;
		q = (o + r * 2) / 3;

		for (int i = p + 1; i <= q; i++)
			s.setCharAt(i, ' ');

		cantor(o, p);
		cantor(q + 1, r);
	}
}
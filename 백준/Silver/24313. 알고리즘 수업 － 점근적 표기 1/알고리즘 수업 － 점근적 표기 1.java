import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int a1, a0, c, n0;

		st = new StringTokenizer(br.readLine());
		a1 = Integer.parseInt(st.nextToken());
		a0 = Integer.parseInt(st.nextToken());

		c = Integer.parseInt(br.readLine());

		n0 = Integer.parseInt(br.readLine());

		for (int n = n0; n <= 100; n++) {
			if (a1 * n + a0 > c * n) {
				bw.write("0\n");
				bw.flush();
				System.exit(0);
			}
		}

		bw.write("1\n");
		bw.flush();
	}

}
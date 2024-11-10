import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, zero = 0, n;
		int[] fctrl0;

		N = Integer.parseInt(br.readLine());
		fctrl0 = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			n = i;

			while (n % 5 == 0) {
				n /= 5;
				zero++;
			}

			fctrl0[i] = zero;
		}

		bw.write(fctrl0[N] + "\n");
		bw.flush();
	}

}
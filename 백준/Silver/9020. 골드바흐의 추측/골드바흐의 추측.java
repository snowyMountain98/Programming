import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T, n;
		boolean[] prime = new boolean[10001];

		for (int i = 1; i <= 10000; i++)
			prime[i] = true;

		for (int i = 2; i <= 10000; i++) {
			if (prime[i])
				for (int j = i * i; j <= 10000; j += i)
					prime[j] = false;
		}

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			n = Integer.parseInt(br.readLine());

			for (int i = n / 2; i >= 1; i--) {
				if (prime[i] && prime[n - i]) {
					bw.write(i + " " + (n - i) + "\n");
					break;
				}
			}

			T--;
		}

		bw.flush();
	}

}
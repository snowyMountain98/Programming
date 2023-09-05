import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] prime = new boolean[1000001];
		int t, n, goldbach;

		for (int i = 2; i <= 1000000; i++)
			prime[i] = true;

		for (int i = 2; i * i <= 1000000; i++) {
			if (prime[i])
				for (int j = i * i; j <= 1000000; j += i)
					prime[j] = false;
		}

		t = Integer.parseInt(br.readLine());

		while (t > 0) {
			n = Integer.parseInt(br.readLine());
			goldbach = 0;

			for (int i = 2; 2 * i <= n; i++) {
				if (prime[i] && prime[n - i])
					goldbach++;
			}

			bw.write(goldbach + "\n");
			bw.flush();

			t--;
		}
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long t, n;

		t = Long.parseLong(br.readLine());

		while (t > 0) {
			n = Long.parseLong(br.readLine());

			while (!isPrime(n))
				n++;

			bw.write(n + "\n");

			t--;
		}

		bw.flush();
	}

	public static boolean isPrime(long n) {
		if (n < 2)
			return false;

		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}
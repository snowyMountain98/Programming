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
		boolean[] prime;
		int m, n;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		prime = new boolean[n + 1];

		for (int i = 2; i <= n; i++)
			prime[i] = true;

		for (int i = 2; i * i <= n; i++) {
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
		}

		for (int i = m; i <= n; i++) {
			if (prime[i])
				bw.write(i + "\n");
		}

		bw.flush();
	}

}
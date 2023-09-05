import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n, num;

		do {
			n = Integer.parseInt(br.readLine());
			num = 0;

			LOOP:
			for (int i = n + 1; i <= 2 * n; i++) {
				for (int j = 2; j * j <= i; j++) {
					if (i % j == 0)
						continue LOOP;
				}

				num++;
			}

			if (num != 0)
				bw.write(num + "\n");
			
			bw.flush();
		} while (n != 0);
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X, i, dnmnt /* 분모 */, nmrtr /* 분자 */;

		X = Integer.parseInt(br.readLine());

		i = 1;

		while (X - i > 0) {
			X -= i;
			i++;
		}

		if (i % 2 == 0) {
			nmrtr = X;
			dnmnt = i - X + 1;
		} else {
			nmrtr = i - X + 1;
			dnmnt = X;
		}

		bw.write(nmrtr + "/" + dnmnt + "\n");
		bw.flush();
	}

}
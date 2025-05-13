import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] S;
		int one = 0, zero = 0;

		S = br.readLine().toCharArray();

		if (S[0] == '0')
			zero++;
		else
			one++;

		for (int i = 1; i < S.length; i++) {
			if (S[i - 1] == '0' && S[i] == '1')
				one++;
			else if (S[i - 1] == '1' && S[i] == '0')
				zero++;
		}

		bw.write(Math.min(zero, one) + "\n");
		bw.flush();
	}

}
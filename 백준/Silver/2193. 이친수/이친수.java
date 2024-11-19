import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		long[] pnryNum = new long[91];

		N = Integer.parseInt(br.readLine());

		pnryNum[1] = 1;
		pnryNum[2] = 1;
		pnryNum[3] = 2;

		for (int i = 4; i <= N; i++) {
			for (int j = 1; j <= i - 2; j++)
				pnryNum[i] += pnryNum[j];

			pnryNum[i] += 1;
		}

		bw.write(pnryNum[N] + "\n");
		bw.flush();
	}

}
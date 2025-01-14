import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] set = new int[9];
		int max = 0;
		String N;

		N = br.readLine();

		for (int i = 0; i < N.length(); i++) {
			int now = N.charAt(i) - '0';

			if (now == 6 || now == 9)
				set[6]++;
			else
				set[now]++;
		}

		set[6] = (int) Math.ceil(set[6] / 2.0);

		for (int i = 0; i < 9; i++)
			if (max < set[i])
				max = set[i];

		bw.write(max + "\n");
		bw.flush();
	}

}
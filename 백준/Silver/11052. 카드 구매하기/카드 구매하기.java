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
		int N;
		int[] P, amnt;

		N = Integer.parseInt(br.readLine());

		P = new int[N + 1];
		amnt = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			P[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++)
				amnt[i] = Math.max(amnt[i], amnt[i - j] + P[j]);
		}

		bw.write(amnt[N] + "\n");
		bw.flush();
	}

}
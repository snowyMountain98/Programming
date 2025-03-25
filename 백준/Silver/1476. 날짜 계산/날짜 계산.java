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
		int E, S, M;

		st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		E = E == 15 ? 0 : E;
		S = S == 28 ? 0 : S;
		M = M == 19 ? 0 : M;

		for (int i = 1; i <= Integer.MAX_VALUE; i++) {
			if (i % 15 == E && i % 28 == S & i % 19 == M) {
				bw.write(i + "\n");
				break;
			}
		}

		bw.flush();
	}

}
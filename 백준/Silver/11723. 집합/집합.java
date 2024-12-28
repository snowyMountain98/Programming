import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[] S = new boolean[21];
		String cmnd;
		int M, x;

		M = Integer.parseInt(br.readLine());

		while (M > 0) {
			st = new StringTokenizer(br.readLine());
			cmnd = st.nextToken();

			switch (cmnd) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				S[x] = true;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				S[x] = false;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if (S[x])
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				S[x] = S[x] ? false : true;
				break;
			case "all":
				for (int i = 1; i <= 20; i++)
					S[i] = true;
				break;
			case "empty":
				S = new boolean[21];
				break;
			}

			M--;
		}

		bw.flush();
	}

}
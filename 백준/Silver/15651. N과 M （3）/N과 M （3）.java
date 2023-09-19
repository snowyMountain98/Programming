import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] seq;
	static int n, m;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		seq = new int[m];

		backtracking(0);

		bw.flush();
	}

	public static void backtracking(int index) throws IOException {
		if (index >= m) {
			for (int i = 0; i < m; i++)
				bw.write(seq[i] + " ");
			bw.write("\n");

			return;
		}

		for (int i = 1; i <= n; i++) {
			seq[index] = i;
			backtracking(index + 1);
		}
	}
}
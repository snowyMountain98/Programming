import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> lotto = new ArrayList<>();
	static int k;
	static int[] S;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());

			if (k == 0)
				break;

			S = new int[k];

			for (int i = 0; i < k; i++)
				S[i] = Integer.parseInt(st.nextToken());

			dfs(0);

			bw.write("\n");
			bw.flush();
		}
	}

	public static void dfs(int start) throws IOException {
		if (lotto.size() == 6) {
			for (int i = 0; i < lotto.size(); i++)
				bw.write(lotto.get(i) + " ");
			bw.write("\n");

			return;
		}

		for (int i = start; i < k; i++) {
			lotto.add(S[i]);
			dfs(i + 1);
			lotto.remove(lotto.size() - 1);
		}
	}

}
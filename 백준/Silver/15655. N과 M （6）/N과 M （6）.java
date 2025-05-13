import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] num;
	static List<Integer> seq = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);
		dfs(0, 0);
	}

	public static void dfs(int start, int depth) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (depth == M) {
			for (int i = 0; i < seq.size(); i++)
				bw.write(seq.get(i) + " ");
			bw.write("\n");

			bw.flush();
			return;
		}

		for (int i = start; i < N; i++) {
			seq.add(num[i]);
			dfs(i + 1, depth + 1);
			seq.remove(seq.size() - 1);
		}
	}

}
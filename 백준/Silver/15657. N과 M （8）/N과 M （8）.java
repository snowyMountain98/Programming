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
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int[] num;
	static List<Integer> li = new ArrayList<>();

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

		dfs(0);

		bw.flush();
	}

	public static void dfs(int start) throws IOException {
		if (li.size() == M) {
			for (int i : li)
				bw.write(i + " ");
			bw.write("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			li.add(num[i]);
			dfs(i);
			li.remove(li.size() - 1);
		}
	}

}
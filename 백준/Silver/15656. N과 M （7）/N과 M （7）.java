import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer> num = new ArrayList<>();
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num.add(Integer.parseInt(st.nextToken()));

		Collections.sort(num);

		int i = 1;
		while (i < num.size()) {
			if (num.get(i).equals(num.get(i - 1))) {
				num.remove(i);
				continue;
			}

			i++;
		}

		arr = new int[M];

		dfs(0, 0);

		bw.flush();
	}

	public static void dfs(int start, int depth) throws IOException {
		if (depth == M) {
			for (int i : arr)
				bw.write(i + " ");

			bw.write("\n");
			return;
		}

		for (int i = start; i < num.size(); i++) {
			arr[depth] = num.get(i);
			dfs(start, depth + 1);
		}
	}
}
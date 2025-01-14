import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<Integer> sqnc = new ArrayList<>();
	static boolean[] vstd;
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		vstd = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		dfs();

		bw.flush();
	}

	public static void dfs() throws IOException {
		if (sqnc.size() == M) {
			for (int i = 0; i < M; i++)
				bw.write(sqnc.get(i) + " ");
			bw.write("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (vstd[i])
				continue;

			sqnc.add(arr[i]);
			vstd[i] = true;
			dfs();
			sqnc.remove(sqnc.size() - 1);
			vstd[i] = false;
		}
	}

}
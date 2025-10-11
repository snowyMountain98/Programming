import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] vstd;
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		vstd = new boolean[N + 1];

		dfs(0);

		bw.flush();
	}

	public static void dfs(int depth) throws IOException {
		if (depth == N) {
			for (int i = 0; i < N; i++)
				bw.write(arr[i] + " ");
			bw.write("\n");
		}

		for (int i = 1; i <= N; i++) {
			if (vstd[i])
				continue;

			vstd[i] = true;
			arr[depth] = i;
			dfs(depth + 1);
			vstd[i] = false;
		}
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, S, sum, cnt = 0;
	static int[] sqnc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		sqnc = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			sqnc[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			sum = sqnc[i];
			dfs(i + 1);
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	public static void dfs(int start) {
		if (sum == S)
			cnt++;

		for (int i = start; i < N; i++) {
			sum += sqnc[i];
			dfs(i + 1);
			sum -= sqnc[i];
		}

	}

}
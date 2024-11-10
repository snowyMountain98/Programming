import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, prft, max = Integer.MIN_VALUE;
	static int[] T, P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		T = new int[N + 1];
		P = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1);

		bw.write(max + "\n");
		bw.flush();
	}

	public static void dfs(int start) {
		max = Math.max(max, prft);

		/* 현재 시작일부터 마지막 날까지 탐색 */
		for (int i = start; i <= N; i++) {
			/* 현재 상담이 종료되는 날이 N일을 초과하면 스킵 */
			if (i + T[i] - 1 > N)
				continue;

			prft += P[i];
			dfs(i + T[i]);
			prft -= P[i];
		}
	}

}
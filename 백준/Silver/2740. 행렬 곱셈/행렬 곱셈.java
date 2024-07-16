import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, K;
		int[][] A, B, rslt;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		B = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}

		rslt = new int[N][K];

		for (int h = 0; h < N; h++) {
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < M; j++)
					rslt[h][i] += A[h][j] * B[j][i];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++)
				bw.write(rslt[i][j] + " ");
			bw.write("\n");
		}

		bw.flush();
	}

}
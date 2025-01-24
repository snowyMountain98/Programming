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
		int N;
		int[][] adjcnMtrx;

		N = Integer.parseInt(br.readLine());

		adjcnMtrx = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++)
				adjcnMtrx[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= N; j++)
					if (adjcnMtrx[i][k] == 1 && adjcnMtrx[k][j] == 1)
						adjcnMtrx[i][j] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++)
				bw.write(adjcnMtrx[i][j] + " ");
			bw.write("\n");
		}
		bw.flush();
	}

}
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
		int T, K;
		int[] fileSize, sum;
		int[][] minCost;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			fileSize = new int[K + 1];
			sum = new int[K + 1];
			minCost = new int[K + 1][K + 1];

			fileSize[1] = Integer.parseInt(st.nextToken());
			sum[1] = fileSize[1];

			for (int i = 2; i <= K; i++) {
				fileSize[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + fileSize[i];
			}

			for (int gap = 1; gap < K; gap++) {
				for (int start = 1; start + gap <= K; start++) {
					int end = start + gap;
					minCost[start][end] = Integer.MAX_VALUE;

					for (int mid = start; mid < end; mid++)
						minCost[start][end] = Math.min(minCost[start][end],
								minCost[start][mid] + minCost[mid + 1][end] + sum[end] - sum[start - 1]);
				}
			}

			/**************************************************
			 * fileSize : [40, 30, 30, 50]
			 * minCost :
			 * [0, 70, 160, 300]
			 * [0,  0,  60, 170]
			 * [0,  0,   0,  80]
			 * [0,  0,   0,   0]
			 **************************************************/

			bw.write(minCost[1][K] + "\n");
			bw.flush();

			T--;
		}
	}

}
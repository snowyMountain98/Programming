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
		int[][] mtrx, mtrxMltpl;
		int N;

		N = Integer.parseInt(br.readLine());

		mtrx = new int[N][2];
		mtrxMltpl = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			mtrx[i][0] = Integer.parseInt(st.nextToken());
			mtrx[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++)
			mtrxMltpl[i][i + 1] = mtrx[i][0] * mtrx[i][1] * mtrx[i + 1][1];

		for (int gap = 2; gap < N; gap++) {
			for (int start = 0; start + gap < N; start++) {
				int end = start + gap;

				mtrxMltpl[start][end] = Integer.MAX_VALUE;
				for (int mid = start; mid < end; mid++)
					mtrxMltpl[start][end] = Math.min(mtrxMltpl[start][end], mtrxMltpl[start][mid]
							+ mtrxMltpl[mid + 1][end] + (mtrx[start][0] * mtrx[mid][1] * mtrx[end][1]));
			}
		}
		
		/**************************************************
		 * mtrxMltpl :
		 * [0, 30, 90]
		 * [0,  0, 36]
		 * [0,  0,  0]
		 **************************************************/

		bw.write(mtrxMltpl[0][N - 1] + "\n");
		bw.flush();
	}

}
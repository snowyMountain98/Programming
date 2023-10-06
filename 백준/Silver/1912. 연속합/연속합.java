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
		int[] arr, maxSum;
		int n, max;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		maxSum = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		maxSum[0] = arr[0];
		max = maxSum[0];

		for (int i = 1; i < n; i++) {
			maxSum[i] = Math.max(maxSum[i - 1] + arr[i], arr[i]);
			max = Math.max(max, maxSum[i]);
		}

		/************************************************************
		 * arr		: [10, -4, 3,  1,  5,  6, -35, 12, 21, -1]
		 * maxSum	: [10,  6, 9, 10, 15, 21, -14, 12, 33, 32]
		 ************************************************************/

		bw.write(max + "\n");
		bw.flush();
	}

}
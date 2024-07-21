import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, num, low, mid, hgh, exist;
		int[] A;

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);

		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		while (M > 0) {
			num = Integer.parseInt(st.nextToken());
			exist = 0;

			low = 0;
			hgh = A.length - 1;

			while (low <= hgh) {
				mid = (low + hgh) / 2;

				if (num < A[mid])
					hgh = mid - 1;
				else if (num > A[mid])
					low = mid + 1;
				else {
					exist = 1;
					break;
				}
			}

			bw.write(exist + "\n");
			bw.flush();

			M--;
		}
	}

}
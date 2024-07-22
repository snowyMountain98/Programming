import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] lan;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K, N;
		long low, hgh, mid;

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lan = new int[K];

		for (int i = 0; i < K; i++)
			lan[i] = Integer.parseInt(br.readLine());

		Arrays.sort(lan);

		low = 1;
		hgh = lan[lan.length - 1];

		while (low <= hgh) {
			mid = (low + hgh) / 2;

			if (cutLan(mid) < N)
				hgh = mid - 1;
			else
				low = mid + 1;
		}

		bw.write(hgh + "\n");
		bw.flush();
	}

	public static int cutLan(long length) {
		int num = 0;

		for (int i = 0; i < lan.length; i++)
			num += lan[i] / length;

		return num;
	}

}
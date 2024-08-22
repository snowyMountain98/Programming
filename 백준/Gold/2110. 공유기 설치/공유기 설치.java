import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, C, low, hgh, mid;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		x = new int[N];

		for (int i = 0; i < N; i++)
			x[i] = Integer.parseInt(br.readLine());

		Arrays.sort(x);

		low = 1;
		hgh = x[x.length - 1];

		while (low <= hgh) {
			mid = (low + hgh) / 2;

			if (instlRout(mid) < C)
				hgh = mid - 1;
			else
				low = mid + 1;
		}

		bw.write(hgh + "\n");
		bw.flush();
	}

	public static int instlRout(int mid) {
		int now = 0, cnt = 1;

		for (int i = 1; i < x.length; i++) {
			if (x[i] >= x[now] + mid) {
				cnt++;
				now = i;
			}
		}

		return cnt;
	}

}
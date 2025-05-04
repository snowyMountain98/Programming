import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, x, cnt = 0, start, end;
		int[] a;

		n = Integer.parseInt(br.readLine());

		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		x = Integer.parseInt(br.readLine());

		Arrays.sort(a);

		start = 0;
		end = a.length - 1;

		while (start < end) {
			int sum = a[start] + a[end];

			if (sum == x) {
				cnt++;
				start++;
				end--;
			} else if (sum > x)
				end--;
			else
				start++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

}
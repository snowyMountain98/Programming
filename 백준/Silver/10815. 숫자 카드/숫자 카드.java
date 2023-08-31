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
		int n, m;
		int[] card, num;

		n = Integer.parseInt(br.readLine());

		card = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			card[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(card);

		m = Integer.parseInt(br.readLine());

		num = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			num[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			if (Arrays.binarySearch(card, num[i]) >= 0)
				bw.write("1 ");
			else
				bw.write("0 ");
		}

		bw.flush();
	}

}
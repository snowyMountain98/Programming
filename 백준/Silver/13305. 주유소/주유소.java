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
		int N, now;
		long cost = 0;
		long[] lgRd /* 도로의 길이 */, pxL /* 리터당 가격 */;

		N = Integer.parseInt(br.readLine());

		lgRd = new long[N - 1];
		pxL = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			lgRd[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			pxL[i] = Integer.parseInt(st.nextToken());

		now = 0;
		cost += lgRd[0] * pxL[now];

		for (int i = 1; i < N - 1; i++) {
			if (pxL[i] < pxL[now])
				now = i;

			cost += lgRd[i] * pxL[now];
		}

		bw.write(cost + "\n");
		bw.flush();
	}

}
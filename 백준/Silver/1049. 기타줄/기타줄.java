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
		int N, M, min = Integer.MAX_VALUE, a, b, pckagMin = Integer.MAX_VALUE, pieceMin = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			pckagMin = Math.min(pckagMin, Integer.parseInt(st.nextToken()));
			pieceMin = Math.min(pieceMin, Integer.parseInt(st.nextToken()));
		}

		/* 필요한 패키지 최대 개수 */
		a = (int) Math.ceil((double) N / 6);
		b = 0;

		/* 패키지 개수를 하나씩 줄이면서 모든 경우 계산 */
		while (a >= 0) {
			int sum = a * pckagMin + b * pieceMin;	// 현재 비용 계산
			min = Math.min(min, sum);	// 최소값 갱신

			a--;	// 패키지 하나 줄이기
			b = N - 6 * a;	// 패키지 하나 줄이기
		}

		bw.write(min + "\n");
		bw.flush();
	}

}
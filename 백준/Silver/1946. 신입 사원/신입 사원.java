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
		int T, N, cnt, min;
		int[] rank;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			N = Integer.parseInt(br.readLine());

			rank = new int[N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int intrv = Integer.parseInt(st.nextToken());
				rank[paper] = intrv;	// 서류 순위를 인덱스로 하여 면접 순위 저장
			}

			cnt = 1;		// 서류 1등은 항상 선발
			min = rank[1];	// 최소 면접 순위 초기화

			/* 서류 순위 2등부터 N등까지 반복 */
			for (int i = 2; i <= N; i++) {
				/* 현재 사람의 면접 순위가 더 좋으면 선발 */
				if (min > rank[i]) {
					cnt++;
					min = rank[i];
				}
			}

			bw.write(cnt + "\n");

			T--;
		}

		bw.flush();
	}

}
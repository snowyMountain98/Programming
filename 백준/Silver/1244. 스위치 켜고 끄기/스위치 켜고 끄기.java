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
		int N, M, sex, num;
		int[] swtch;

		N = Integer.parseInt(br.readLine());

		swtch = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			swtch[i] = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		while (M > 0) {
			st = new StringTokenizer(br.readLine());

			sex = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			switch (sex) {
			/* 남학생 */
			case 1:
				/* 자기가 받은 숫자의 배수 위치 스위치를 모두 반전 */
				for (int i = 1; i <= N; i++) {
					if (i % num == 0)
						swtch[i] = 1 - swtch[i];
				}
				break;
			/* 여학생 */
			case 2:
				/* 받은 숫자 위치의 스위치를 먼저 반전 */
				swtch[num] = 1 - swtch[num];

				int d = 1;
				/* 좌우 대칭이면서 같은 상태인 스위치를 찾을 수 있는 동안 반복 */
				while (num + d <= N && num > d && swtch[num + d] == swtch[num - d]) {
					/* 좌우 스위치 모두 반전 */
					swtch[num + d] = 1 - swtch[num + d];
					swtch[num - d] = 1 - swtch[num - d];
					d++;
				}
			}

			M--;
		}

		for (int i = 1; i <= N; i++) {
			bw.write(swtch[i] + " ");

			if (i % 20 == 0)
				bw.write("\n");
		}
		bw.write("\n");
		bw.flush();
	}

}
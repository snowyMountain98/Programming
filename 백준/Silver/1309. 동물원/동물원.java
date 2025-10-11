import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long cage[][];
		int N;

		N = Integer.parseInt(br.readLine());

		/**
		 * cage[i][j]: i번째 줄까지 배치했을 때의 경우의 수
		 * j = 0 → i번째 줄에 아무 사자도 배치하지 않음
		 * j = 1 → i번째 줄 왼쪽 칸에 사자 배치
		 * j = 2 → i번째 줄 오른쪽 칸에 사자 배치
		 */
		cage = new long[N + 1][3];

		/* 초기값 (1번째 줄) */
		cage[1][0] = 1;
		cage[1][1] = 1;
		cage[1][2] = 1;

		/* 점화식으로 경우의 수 계산 */
		for (int i = 2; i <= N; i++) {
			/* 현재 줄에 사자를 배치하지 않는 경우: 이전 줄의 모든 경우 가능 */
			cage[i][0] = (cage[i - 1][0] + cage[i - 1][1] + cage[i - 1][2]) % 9901;

			/* 현재 줄에 왼쪽 칸에만 배치하는 경우: 이전 줄이 "사자 없음" 또는 "오른쪽 칸만" 가능 */
			cage[i][1] = (cage[i - 1][0] + cage[i - 1][2]) % 9901;

			/* 현재 줄에 오른쪽 칸에만 배치하는 경우: 이전 줄이 "사자 없음" 또는 "왼쪽 칸만" 가능 */
			cage[i][2] = (cage[i - 1][0] + cage[i - 1][1]) % 9901;
		}

		bw.write((cage[N][0] + cage[N][1] + cage[N][2]) % 9901 + "\n");
		bw.flush();
	}

}
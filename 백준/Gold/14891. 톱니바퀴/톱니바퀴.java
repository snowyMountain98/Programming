import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] d;	// 각 톱니바퀴의 회전 방향
	static int[][] cgwhl = new int[5][9];	// 톱니바퀴 상태

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K, score = 0;
		int[][] turn;

		for (int i = 1; i <= 4; i++) {
			String str = br.readLine();

			for (int j = 1; j <= 8; j++)
				cgwhl[i][j] = str.charAt(j - 1) - '0';
		}

		K = Integer.parseInt(br.readLine());

		turn = new int[K + 1][2];

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken()); // 회전시킬 톱니바퀴 번호
			turn[i][1] = Integer.parseInt(st.nextToken()); // 회전 방향 (1: 시계, -1: 반시계)
		}

		/* 각 회전 명령 처리 */
		for (int i = 1; i <= K; i++) {
			d = new int[5];

			/* 회전 영향을 받는 톱니바퀴들을 확인하고 회전 방향 설정 */
			switch (turn[i][0]) {
			case 1:
				d[1] = turn[i][1];
				d[2] = cgwhl[1][3] == cgwhl[2][7] ? 0 : d[1] * -1;
				d[3] = cgwhl[2][3] == cgwhl[3][7] ? 0 : d[2] * -1;
				d[4] = cgwhl[3][3] == cgwhl[4][7] ? 0 : d[3] * -1;
				break;
			case 2:
				d[2] = turn[i][1];
				d[1] = cgwhl[1][3] == cgwhl[2][7] ? 0 : d[2] * -1;
				d[3] = cgwhl[2][3] == cgwhl[3][7] ? 0 : d[2] * -1;
				d[4] = cgwhl[3][3] == cgwhl[4][7] ? 0 : d[3] * -1;
				break;
			case 3:
				d[3] = turn[i][1];
				d[2] = cgwhl[2][3] == cgwhl[3][7] ? 0 : d[3] * -1;
				d[4] = cgwhl[3][3] == cgwhl[4][7] ? 0 : d[3] * -1;
				d[1] = cgwhl[1][3] == cgwhl[2][7] ? 0 : d[2] * -1;
				break;
			case 4:
				d[4] = turn[i][1];
				d[3] = cgwhl[3][3] == cgwhl[4][7] ? 0 : d[4] * -1;
				d[2] = cgwhl[2][3] == cgwhl[3][7] ? 0 : d[3] * -1;
				d[1] = cgwhl[1][3] == cgwhl[2][7] ? 0 : d[2] * -1;
				break;
			}

			rotate();	// 실제 회전 수행
		}

		/* 회전 완료 후 점수 계산 (각 톱니바퀴의 12시 방향이 1이면 점수 부여) */
		for (int i = 1; i <= 4; i++) {
			if (cgwhl[i][1] == 1)
				score += Math.pow(2, i - 1);
		}

		bw.write(score + "\n");
		bw.flush();
	}

	/**
	 * 톱니바퀴 회전
	 */
	public static void rotate() {
		int temp;

		for (int i = 1; i <= 4; i++) {
			/* 시계 방향 회전 */
			if (d[i] == 1) {
				temp = cgwhl[i][8];

				for (int j = 8; j > 1; j--)
					cgwhl[i][j] = cgwhl[i][j - 1];

				cgwhl[i][1] = temp;
			}
			/* 반시계 방향 회전 */
			else if (d[i] == -1) {
				temp = cgwhl[i][1];

				for (int j = 1; j <= 7; j++)
					cgwhl[i][j] = cgwhl[i][j + 1];

				cgwhl[i][8] = temp;
			}
		}
	}

}
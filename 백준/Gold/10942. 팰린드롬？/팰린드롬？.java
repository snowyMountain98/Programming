import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num;
	static boolean[][] plndr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int M, S, E;

		N = Integer.parseInt(br.readLine());

		num = new int[N + 1];
		plndr = new boolean[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		/* DP로 팰린드롬 여부 계산 */
		setPlndr();

		/****************************************
		 *   1   2   1   3   1   2   1
		 * ┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓
		 * ┃ T ┃ F ┃ T ┃ F ┃ F ┃ F ┃ T ┃
		 * ┡━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
		 * │ F ┃ T ┃ F ┃ F ┃ F ┃ T ┃ F ┃
		 * ├───╄━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫
		 * │ F │ F ┃ T ┃ F ┃ T ┃ F ┃ F ┃
		 * ├───┼───╄━━━╋━━━╋━━━╋━━━╋━━━┫
		 * │ F │ F │ F ┃ T ┃ F ┃ F ┃ F ┃
		 * ├───┼───┼───╄━━━╋━━━╋━━━╋━━━┫
		 * │ F │ F │ F │ F ┃ T ┃ F ┃ T ┃
		 * ├───┼───┼───┼───╄━━━╋━━━╋━━━┫
		 * │ F │ F │ F │ F │ F ┃ T ┃ F ┃
		 * ├───┼───┼───┼───┼───╄━━━╋━━━┫
		 * │ F │ F │ F │ F │ F │ F ┃ T ┃
		 * └───┴───┴───┴───┴───┴───┺━━━┛
		 ****************************************/

		M = Integer.parseInt(br.readLine());

		/* M개의 (S, E) 구간에 대해 팰린드롬인지 출력 */
		while (M > 0) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			if (plndr[S][E])
				bw.write("1\n");
			else
				bw.write("0\n");
			M--;
		}

		bw.flush();
	}

	/**
	 * 팰린드롬 DP 테이블을 채우는 메서드
	 */
	public static void setPlndr() {
		/* 1. 길이가 1인 구간: 항상 팰린드롬 */
		for (int i = 1; i <= N; i++)
			plndr[i][i] = true;

		/* 2. 길이가 2인 구간: num[i]와 num[i+1]이 같으면 팰린드롬 */
		for (int i = 1; i < N; i++) {
			if (num[i] == num[i + 1])
				plndr[i][i + 1] = true;
		}

		/* 3. 길이가 3 이상인 구간의 팰린드롬 여부 계산
		 * 		구간 길이를 i라고 할 때,
		 * 		j ~ (j+i)가 팰린드롬이 되려면
		 * 		- 내부 구간 (j+1) ~ (j+i-1)이 팰린드롬이고
		 * 		- 바깥 숫자 num[j] == num[j+i] 이어야 한다.
		 */
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j + i <= N; j++) {
				if (plndr[j + 1][j + i - 1] && num[j] == num[j + i])
					plndr[j][j + i] = true;
			}
		}
	}

}
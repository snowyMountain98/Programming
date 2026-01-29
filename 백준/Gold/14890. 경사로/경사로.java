import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cnt = 0;
		int[][] map;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			/* i번째 행이 통과 가능하면 카운트 증가 */
			if (passable(map[i]))
				cnt++;

			/* 세로 방향 검사를 위해 열을 1차원 배열로 변환 */
			int[] a = new int[N];

			for (int j = 0; j < N; j++)
				a[j] = map[j][i];

			/* i번째 열이 통과 가능하면 카운트 증가 */
			if (passable(a))
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

	/**
	 * 길이 통과 가능한지 판별
	 */
	public static boolean passable(int[] way) {
		boolean[] ramp = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			/* 높이 차이가 2 이상이면 경사로 설치 불가 */
			if (Math.abs(way[i] - way[i + 1]) > 1)
				return false;

			/* 오르막 경사로 설치 */
			if (way[i] < way[i + 1]) {
				/* 뒤쪽 L칸 확인 */
				for (int j = i - L + 1; j <= i; j++) {
					/* 범위 초과, 이미 경사로 있음, 높이가 다르면 실패 */
					if (j < 0 || ramp[j] || way[j] != way[i])
						return false;

					/* 경사로 설치 표시 */
					ramp[j] = true;
				}
			}
			/* 내리막 경사로 설치 */
			else if (way[i] > way[i + 1]) {
				/* 앞쪽 L칸 확인 */
				for (int j = i + 1; j <= i + L; j++) {
					/* 범위 초과, 이미 경사로 있음, 높이가 다르면 실패 */
					if (j >= N || ramp[j] || way[j] != way[i + 1])
						return false;

					/* 경사로 설치 표시 */
					ramp[j] = true;
				}
			}
		}
		return true;
	}
}
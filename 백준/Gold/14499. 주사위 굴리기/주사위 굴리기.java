import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, x, y, K;
		int[] cmnd;
		int[] dx = { 0, 0, 0, -1, 1 }, dy = { 0, 1, -1, 0, 0 };
		int[][] map;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		cmnd = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++)
			cmnd[i] = Integer.parseInt(st.nextToken());

		dice = new int[7];

		for (int i = 0; i < K; i++) {
			/* 다음 위치 계산 */
			int nx = x + dx[cmnd[i]];
			int ny = y + dy[cmnd[i]];

			/* 범위를 벗어나면 명령 무시 */
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;

			/* 주사위 굴리기 */
			rollDice(cmnd[i]);

			/* 이동한 칸이 0이면 주사위 바닥면 값을 복사 */
			if (map[nx][ny] == 0)
				map[nx][ny] = dice[6];
			/* 0이 아니면 칸의 값을 주사위 바닥면으로 복사하고 칸은 0으로 초기화 */
			else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}

			bw.write(dice[1] + "\n");
			
			/* 현재 위치 갱신 */
			x = nx;
			y = ny;
		}

		bw.flush();
	}

	public static void rollDice(int dir) {
		int tmp;

		switch (dir) {
		case 1:	// 동쪽
			tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;
		case 2:	// 서쪽
			tmp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			break;
		case 3:	// 북쪽
			tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 4:	// 남쪽
			tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
	}

}
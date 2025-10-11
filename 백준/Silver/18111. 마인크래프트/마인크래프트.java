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
		int N, M, B, min = 0, max = 64000000, time = Integer.MAX_VALUE, height = 0;
		int[][] land;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		land = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				land[i][j] = Integer.parseInt(st.nextToken());

				/* 최소/최대 높이 갱신 */
				min = Math.min(land[i][j], min);
				max = Math.max(land[i][j], max);
			}
		}

		/* 땅의 높이는 최대 256까지 */
		max = Math.min(max, 256);

		/* 가능한 모든 높이(min ~ max) 시뮬레이션 */
		AA: for (int h = min; h <= max; h++) {
			int sec = 0;	// 현재 높이를 맞추는데 걸린 시간
			int invnt = B;	// 인벤토리에 있는 블록 개수

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					/* 현재 땅이 목표 높이(h)보다 높을 경우 → 블록 제거 */
					if (land[i][j] >= h) {
						sec += (land[i][j] - h) * 2;	// 제거는 블록 1개당 2초
						invnt += (land[i][j] - h);		// 제거한 블록은 인벤토리에 저장
					}
					/* 현재 땅이 목표 높이(h)보다 낮을 경우 → 블록 추가 */
					else {
						sec += h - land[i][j];		// 추가는 블록 1개당 1초
						invnt -= h - land[i][j];	// 인벤토리에서 블록 사용
					}

					/* 가지치기: 현재 시간이 최소 시간보다 커지면 중단 */
					if (sec > time)
						continue AA;
				}
			}

			/* 블록이 부족하면 현재 높이 불가능 → 다음 높이로 넘어감 */
			if (invnt < 0)
				continue AA;

			/* 최소 시간 갱신 */
			if (time >= sec) {
				time = sec;
				height = Math.max(h, height);	// 같은 시간이 걸린다면 더 높은 땅을 선택
			}
		}

		bw.write(time + " " + height + "\n");
		bw.flush();
	}

}
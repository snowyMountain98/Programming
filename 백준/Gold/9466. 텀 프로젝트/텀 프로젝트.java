import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int[] stdnt;
	static boolean[] chckd, vstd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, n;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			n = Integer.parseInt(br.readLine());

			cnt = 0;
			stdnt = new int[n + 1];
			chckd = new boolean[n + 1];
			vstd = new boolean[n + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++)
				stdnt[i] = Integer.parseInt(st.nextToken());

			/* 모든 학생에 대해 DFS 수행 */
			for (int i = 1; i <= n; i++)
				dfs(i);

			/* 전체 학생 수 - 사이클에 속한 학생 수 = 팀에 못 드는 학생 수 */
			bw.write((n - cnt) + "\n");
			T--;
		}

		bw.flush();
	}

	/**
	 * DFS를 통해 사이클(팀) 탐색
	 */
	public static void dfs(int now) {
		/* 이미 처리 완료된 노드면 다시 볼 필요 없음 */
		if (chckd[now])
			return;

		/* 현재 DFS 경로에서 다시 방문한 경우 → 사이클 발견 */
		if (vstd[now]) {
			chckd[now] = true;
			cnt++; // 사이클에 속한 학생 수 증가
		}

		vstd[now] = true;

		/* 다음 학생으로 DFS 진행 */
		dfs(stdnt[now]);

		chckd[now] = true;
		vstd[now] = false;
	}
}
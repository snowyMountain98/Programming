import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] prnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M;
		int[] plan;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		prnt = new int[N + 1];
		for (int i = 1; i <= N; i++)
			prnt[i] = i;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			/* 도시 i와 도시 j가 연결되어 있다면 */
			for (int j = 1; j <= N; j++) {
				if ("1".equals(st.nextToken()))
					union(i, j);	// 두 도시를 같은 집합으로 합침
			}
		}

		plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			plan[i] = Integer.parseInt(st.nextToken());

		/* 여행 계획에 있는 모든 도시가 같은 집합에 속하는지 확인 */
		for (int i = 1; i < M; i++) {
			if (prnt[plan[0]] != prnt[plan[i]]) {	// 부모가 다르면 같은 그룹이 아님
				bw.write("NO\n");
				bw.flush();
				System.exit(0);
			}
		}

		/* 모든 도시가 같은 집합에 속한다면 여행 가능 */
		bw.write("YES\n");
		bw.flush();
	}

	/**
	 * 유니온 함수: 두 원소를 같은 집합으로 합침
	 * @param a
	 * @param b
	 */
	public static void union(int a, int b) {
		int x, y;

		x = find(a);	// a의 대표 노드 찾기
		y = find(b);	// b의 대표 노드 찾기

		/* 더 작은 번호를 부모로 설정 */
		if (x < y)
			prnt[y] = x;
		else
			prnt[x] = y;
	}

	/**
	 * 파인드 함수: 특정 원소가 속한 집합을 찾음
	 * @param a
	 * @return
	 */
	public static int find(int a) {
		/* 자기 자신이 부모라면 대표 노드 */
		if (prnt[a] == a)
			return a;
		else
			return prnt[a] = find(prnt[a]);	// 경로 압축 적용
	}

}
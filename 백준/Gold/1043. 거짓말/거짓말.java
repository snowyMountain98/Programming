import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, tNum, lie;
		int[] truth;
		ArrayList<Integer>[] party;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		/* 각 사람을 자기 자신이 대표인 그룹으로 초기화 */
		group = new int[N + 1];
		for (int i = 1; i <= N; i++)
			group[i] = i;

		st = new StringTokenizer(br.readLine());
		tNum = Integer.parseInt(st.nextToken());

		truth = new int[tNum];
		for (int i = 0; i < tNum; i++)
			truth[i] = Integer.parseInt(st.nextToken());

		party = new ArrayList[M];

		/* 각 파티의 참가자 정보를 입력받고 같은 파티의 사람들을 모두 같은 그룹으로 묶음 */
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();

			Integer.parseInt(st.nextToken());

			int first = Integer.parseInt(st.nextToken());	// 파티의 첫 번째 사람
			party[i].add(first);

			/* 나머지 사람들과 첫 번째 사람을 유니온으로 연결 */
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				party[i].add(n);
				union(first, n);
			}
		}

		lie = M;

		/* 각 파티별로 확인: 진실을 아는 사람과 같은 그룹에 속한 사람이 있으면 거짓말 불가 */
		AA:
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < tNum; j++) {
				/* 현재 파티의 첫 번째 사람과 진실을 아는 사람이 같은 그룹이면 */
				if (find(party[i].get(0)) == find(truth[j])) {
					lie--;	// 거짓말 불가능한 파티이므로 카운트 감소
					continue AA;	// 다음 파티로 이동
				}
			}
		}

		bw.write(lie + "\n");
		bw.flush();
	}

	/**
	 * 유니온 함수: 두 사람을 같은 그룹으로 합침
	 */
	public static void union(int a, int b) {
		int x, y;

		x = find(a);
		y = find(b);

		/* 대표 노드 번호가 더 작은 쪽을 대표로 함 */
		if (x < y)
			group[y] = x;
		else
			group[x] = y;
	}

	/**
	 * 파인드 함수: 해당 사람의 대표 노드를 찾음
	 */
	public static int find(int a) {
		if (group[a] == a)
			return a;
		else
			return group[a] = find(group[a]);
	}
}
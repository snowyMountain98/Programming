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
		int m, n;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		prnt = new int[n + 1];

		for (int i = 1; i <= n; i++)
			prnt[i] = i;

		while (m > 0) {
			st = new StringTokenizer(br.readLine());

			int oprtn = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			/* 합집합 연산 */
			if (oprtn == 0) {
				union(a, b);
			}
			/* 같은 집합 여부 확인 연산 */
			else {
				if (find(a) == find(b))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}

			m--;
		}

		bw.flush();
	}

	/* 원소를 합치는 함수 (Union 연산) */
	public static void union(int a, int b) {
		int x, y;

		x = find(a);	// a의 부모 노드 찾기
		y = find(b);	// b의 부모 노드 찾기

		/* 부모 노드가 다르면 합치기 */
		if (x < y)
			prnt[y] = x;
		else
			prnt[x] = y;
	}

	/* 특정 원소의 대표 노드를 찾는 함수 (Find 연산) */
	public static int find(int a) {
		if (prnt[a] == a)	// 자기 자신이 부모라면 대표 노드
			return a;
		else
			return prnt[a] = find(prnt[a]);	// 재귀적으로 부모를 찾아 올라감
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] prnt;

	/* 간선 정보를 저장하는 클래스 */
	static class Edge implements Comparable<Edge> {
		int A, B, C;

		public Edge(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}

		/* 가중치를 기준으로 정렬 */
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.C, o.C);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int V, E, A, B, C, wght = 0;
		PriorityQueue<Edge> pQ = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			pQ.offer(new Edge(A, B, C));
		}

		prnt = new int[V + 1];
		for (int i = 1; i <= V; i++)
			prnt[i] = i;

		/* Kruskal 알고리즘 */
		while (!pQ.isEmpty()) {
			Edge e = pQ.poll();	// 가중치가 가장 작은 간선 꺼내기

			/* 두 정점이 같은 집합이면 건너뜀 */
			if (find(e.A) == find(e.B))
				continue;

			wght += e.C;		// 최소 비용 갱신
			union(e.A, e.B);	// 두 정점 연결
		}

		/**************************************************
		 * ┌───┐  1  ┌───┐     prnt:
		 * │ 1 ├─────┤ 2 │     ┏━━━┳━━━┳━━━┓
		 * └───┘     └───┘     ┃ 1 ┃ 2 ┃ 3 ┃
		 * ┌───┐  2  ┌───┐     ┡━━━╇━━━╇━━━┩
		 * │ 2 ├─────┤ 3 │     │ 1 │ 2 │ 3 │
		 * └───┘     └───┘     └───┴───┴───┘
		 * ┌───┐  3  ┌───┐
		 * │ 1 ├─────┤ 3 │
		 * └───┘     └───┘
		 *
		 *               ↓↓↓
		 *
		 * ┌───┐  1  ┌───┐     prnt:
		 * │ 1 ├─────┤ 2 │     ┏━━━┳━━━┳━━━┓
		 * └───┘     └─┬─┘     ┃ 1 ┃ 2 ┃ 3 ┃
		 *             │2      ┡━━━╇━━━╇━━━┩
		 *           ┌─┴─┐     │ 1 │ 1 │ 1 │
		 *           │ 3 │     └───┴───┴───┘
		 *           └───┘
		 **************************************************/

		bw.write(wght + "\n");
		bw.flush();
	}

	/* 특정 원소의 부모를 찾는 함수 */
	public static int find(int a) {
		if (prnt[a] == a)
			return a;
		else
			return prnt[a] = find(prnt[a]);	// 경로 압축
	}

	/* 두 원소를 합치는 함수 */
	public static void union(int a, int b) {
		int x, y;

		x = prnt[a];
		y = prnt[b];

		if (x < y)
			prnt[y] = x;
		else
			prnt[x] = y;
	}

}
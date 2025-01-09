import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	/* 우선순위 큐에서 사용할 Node 클래스 (정점과 가중치를 포함) */
	static class Node implements Comparable<Node> {
		int vrtx, wght;

		public Node(int vrtx, int wght) {
			this.vrtx = vrtx;
			this.wght = wght;
		}

		/* 정렬 기준 (가중치를 기준으로 정렬) */
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.wght, o.wght);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<ArrayList<Node>> drctnGraph = new ArrayList<>();
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		int V, E, K, u, v, w, newDstnc;
		int[] dstnc;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i <= V; i++)
			drctnGraph.add(new ArrayList<>());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			drctnGraph.get(u).add(new Node(v, w));
		}

		/**************************************************
		 * <drctnGraph>
		 * 1 : [2, 2], [3, 3]
		 * 2 : [3, 4], [4, 5]
		 * 3 : [4, 6]
		 * 4 :
		 * 5 : [1, 1]
		 **************************************************/

		dstnc = new int[V + 1];
		Arrays.fill(dstnc, Integer.MAX_VALUE);
		dstnc[K] = 0;

		pQ.add(new Node(K, 0));

		/* 다익스트라 알고리즘 */
		while (!pQ.isEmpty()) {
			Node crnt = pQ.poll();

			/* 이미 처리된 노드라면 건너뜀 */
			if (crnt.wght > dstnc[crnt.vrtx])
				continue;

			/* 현재 정점의 모든 인접 노드 확인 */
			for (Node nghbr : drctnGraph.get(crnt.vrtx)) {
				newDstnc = dstnc[crnt.vrtx] + nghbr.wght;

				/* 새로운 거리가 기존 거리보다 작으면 갱신 */
				if (newDstnc < dstnc[nghbr.vrtx]) {
					dstnc[nghbr.vrtx] = newDstnc;
					pQ.add(new Node(nghbr.vrtx, newDstnc));
				}
			}
		}

		/**************************************************
		 * 1. (1, 0)
		 * dstnc : [0, ∞, ∞, ∞, ∞]
		 * 	1-ⅰ. (2, 2)
		 * 	newDstnc = dstnc[1] + 2 = 2 ⇒ newDstnc < dstnc[2]
		 * 	∴ dstnc[2] = 2 
		 * 	1-ⅱ. (3, 3)
		 * 	newDstnc = dstnc[1] + 3 = 3 ⇒ newDstnc < dstnc[3]
		 * 	∴ dstnc[3] = 3
		 * 
		 * 2. (2, 2)
		 * dstnc : [0, 2, 3, ∞, ∞] 
		 * 	2-ⅰ. (3, 4)
		 * 	newDstnc = dstnc[2] + 4 = 6 ⇒ newDstnc > dstnc[3]
		 * 	2-ⅱ. (4, 5)
		 * 	newDstnc = dstnc[2] + 5 = 7 ⇒ newDstnc < dstnc[4]
		 * 	∴ dstnc[4] = 7
		 * 
		 * 3. (3, 3)
		 * dstnc : [0, 2, 3, 7, ∞] 
		 * 	3-ⅰ. (4, 6)
		 * 	newDstnc = dstnc[3] + 6 = 9 ⇒ newDstnc > dstnc[4]
		 * 
		 * 4. (4, 5)
		 * dstnc : [0, 2, 3, 7, ∞]
		 **************************************************/

		for (int i = 1; i <= V; i++) {
			if (dstnc[i] == Integer.MAX_VALUE)
				bw.write("INF\n");
			else
				bw.write(dstnc[i] + "\n");
		}
		bw.flush();
	}

}

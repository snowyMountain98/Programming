import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		ArrayList<int[]> jwlry = new ArrayList<>();
		int N, K;
		int[] C;
		long price = 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>(Comparator.reverseOrder());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		C = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			jwlry.add(new int[] { M, V });
		}

		/* 보석을 무게 기준 오름차순으로 정렬(무게가 같을 경우에는 가격 순으로 정렬) */
		jwlry.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])	// 무게가 같다면
					return o2[1] - o1[1];	// 가격이 높은 순서대로 정렬
				else
					return o1[0] - o2[0];	// 무게가 낮은 순서대로 정렬
			}
		});

		for (int i = 0; i < K; i++)
			C[i] = Integer.parseInt(br.readLine());

		/* 가방 무게 오름차순 정렬 (가벼운 가방부터) */
		Arrays.sort(C);

		int j = 0;
		/* 각 가방에 대해 순차적으로 보석을 탐색 */
		for (int i = 0; i < K; i++) {
			/* 현재 가방에 담을 수 있는 보석들을 모두 힙에 추가 */
			while (j < N && jwlry.get(j)[0] <= C[i]) {
				pQ.offer(jwlry.get(j)[1]);
				j++;
			}

			/* 현재 가방에 담을 수 있는 보석 중 가격이 가장 높은 보석을 선택 */
			if (!pQ.isEmpty())
				price += pQ.poll();
		}

		bw.write(price + "\n");
		bw.flush();
	}

}
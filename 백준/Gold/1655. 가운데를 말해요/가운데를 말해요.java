import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> maxHp, minHp;
		int N;

		N = Integer.parseInt(br.readLine());

		maxHp = new PriorityQueue<>(Collections.reverseOrder());	// 작은 수들을 담는 최대 힙 (내림차순)
		minHp = new PriorityQueue<>();	// 큰 수들을 담는 최소 힙 (오름차순)

		while (N > 0) {
			int num = Integer.parseInt(br.readLine());

			/* 1. 우선 maxHp에 넣음 */
			maxHp.offer(num);
			/* 2. maxHp의 루트(최대값)가 minHp의 루트(최소값)보다 크다면 교환 */
			/* → 항상 maxHp의 최대값 <= minHp의 최소값 조건 유지 */
			if (!minHp.isEmpty() && maxHp.peek() > minHp.peek()) {
				minHp.offer(maxHp.poll());
				maxHp.offer(minHp.poll());
			}

			/* 3. 두 힙의 크기 차이가 2 이상이면 균형 맞추기 */
			if (maxHp.size() > minHp.size() + 1)
				minHp.offer(maxHp.poll());				
			else if (minHp.size() > maxHp.size() + 1)
				maxHp.offer(minHp.poll());

			
			/**
			 *  num ┃      maxHp     ┃    minHp   ┃ 가운데
			 * ━━━━━╋━━━━━━━━━━━━━━━━╋━━━━━━━━━━━━╋━━━━━━
			 *   1  ┃ [1]            ┃ []         ┃   1  
			 * ─────╂────────────────╂────────────╂──────
			 *   5  ┃ [5, 1]         ┃ []         ┃
			 *      ┃ [1]            ┃ [5]        ┃   1
			 * ─────╂────────────────╂────────────╂──────
			 *   2  ┃ [2, 1]         ┃ [5]        ┃   2
			 * ─────╂────────────────╂────────────╂──────
			 *  10  ┃ [10, 1, 2]     ┃ [5]        ┃
			 *      ┃ [5, 1, 2]      ┃ [10]       ┃
			 *      ┃ [2, 1]         ┃ [5, 10]    ┃   2
			 * ─────╂────────────────╂────────────╂──────
			 *  -99 ┃ [2, 1, -99]    ┃ [5, 10]    ┃   2
			 * ─────╂────────────────╂────────────╂──────
			 *   7  ┃ [7, 2, -99, 1] ┃ [5, 10]    ┃
			 *      ┃ [5, 2, -99, 1] ┃ [7, 10]    ┃
			 *      ┃ [2, 1, -99]    ┃ [5, 10, 7] ┃   2
			 * ─────╂────────────────╂────────────╂──────
			 *   5  ┃ [5, 2, -99, 1] ┃ [5, 10, 7] ┃   5
			 */

			/* 4. 현재 중앙값 출력: 항상 maxHp가 더 많거나 같게 유지되므로 maxHp의 루트가 중앙값 */
			bw.write(maxHp.peek() + "\n");
			N--;
		}

		bw.flush();
	}

}
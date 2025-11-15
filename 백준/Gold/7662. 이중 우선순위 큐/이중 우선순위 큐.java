import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String oprtn;
		int T, k, n;
		TreeMap<Integer, Integer> dpQ;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			k = Integer.parseInt(br.readLine());

			/* TreeMap은 자동으로 키를 오름차순 정렬 */
			dpQ = new TreeMap<>();

			while (k > 0) {
				st = new StringTokenizer(br.readLine());

				oprtn = st.nextToken();
				n = Integer.parseInt(st.nextToken());

				switch (oprtn) {
				/**
				 * I: 정수 n을 큐에 삽입
				 */
				case "I":
					/* 이미 존재하는 값이면 개수를 +1, 없으면 새로 추가 */
					dpQ.put(n, dpQ.getOrDefault(n, 0) + 1);
					break;
				/**
				 * D: 최대값 또는 최소값 삭제
				 */
				case "D":
					/* 큐가 비어 있으면 아무 것도 하지 않음 */
					if (dpQ.isEmpty())
						break;

					/* 최댓값 삭제 */
					if (n == 1) {
						int max = dpQ.lastKey();	// TreeMap의 마지막 키 = 최댓값
						/* 해당 값이 한 개뿐이면 완전히 제거 */
						if (dpQ.get(max) == 1)
							dpQ.remove(max);
						/* 여러 개면 개수만 1 줄이기 */
						else
							dpQ.put(max, dpQ.get(max) - 1);
					}
					/* 최솟값 삭제 */
					else {
						int min = dpQ.firstKey();	// TreeMap의 첫 번째 키 = 최솟값
						/* 해당 값이 한 개뿐이면 완전히 제거 */
						if (dpQ.get(min) == 1)
							dpQ.remove(min);
						/* 여러 개면 개수만 1 줄이기 */
						else
							dpQ.put(min, dpQ.get(min) - 1);
					}

					break;
				}

				k--;
			}

			if (dpQ.isEmpty())
				bw.write("EMPTY\n");
			else
				bw.write(dpQ.lastKey() + " " + dpQ.firstKey() + "\n");

			T--;
		}

		/****************************************
		 *   oprtn  │       dpQ
		 * ─────────┼─────────────────
		 *  I   16  │ {16=1}
		 *  I -5643 │ {-5643=1, 16=1}
		 *  D   -1  │ {16=1}
		 *  D   1   │ {}
		 *  D   1   │ {}
		 *  I  123  │ {123=1}
		 *  D   -1  │ {}
		 ****************************************/

		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, low, hgh, mid = 0;
		int[] A;
		ArrayList<Integer> lngIncS = new ArrayList<>();

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		lngIncS.add(A[0]);

		for (int i = 1; i < N; i++) {
			if (lngIncS.get(lngIncS.size() - 1) < A[i])
				lngIncS.add(A[i]);
			else {
				low = 0;
				hgh = lngIncS.size() - 1;

				while (low < hgh) {
					mid = (low + hgh) / 2;

					if (lngIncS.get(mid) < A[i])
						low = mid + 1;
					else
						hgh = mid;
				}

				lngIncS.set(low, A[i]);
			}
		}
		
		/**************************************************
		 * A : [10, 20, 10, 30, 20, 50]
		 * 
		 *        LIS       │ 다음값 │      결과
		 * ━━━━━━━━━━━━━━━━━┿━━━━━━┿━━━━━━━━━━━━━━━━━
		 * [10]             │ [20] │ [10, 20]
		 * [10, 20]         │ [10] │ [10, 20]
		 * [10, 20]         │ [30] │ [10, 20, 30]
		 * [10, 20, 30]     │ [20] │ [10, 20, 30]
		 * [10, 20, 30]     │ [50] │ [10, 20, 30, 50]
		 * [10, 20, 30, 50] │      │
		 **************************************************/

		bw.write(lngIncS.size() + "\n");
		bw.flush();
	}
}
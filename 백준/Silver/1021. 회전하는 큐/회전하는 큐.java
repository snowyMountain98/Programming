import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M, cnt = 0;
		int[] a;
		LinkedList<Integer> dQ = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			a[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			dQ.addLast(i);

		for (int i = 0; i < M; i++) {
			/* 뽑아야 할 숫자가 큐의 앞쪽에 있는 경우 */
			if (dQ.indexOf(a[i]) <= dQ.size() / 2) {
				while (dQ.peek() != a[i]) {
					dQ.addLast(dQ.pollFirst()); // 맨 앞 숫자를 맨 뒤로 보냄
					cnt++;
				}
			}
			/* 뽑아야 할 숫자가 큐의 뒤쪽에 있는 경우 */
			else {
				while (dQ.peek() != a[i]) {
					dQ.addFirst(dQ.pollLast()); // 맨 뒤 숫자를 맨 앞으로 보냄
					cnt++;
				}
			}

			dQ.pollFirst();
		}

		bw.write(cnt + "\n");
		bw.flush();
	}

}
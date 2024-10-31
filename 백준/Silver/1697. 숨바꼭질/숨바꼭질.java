import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, K, X, sec;
		boolean[] vstd = new boolean[100001];
		Queue<int[]> queue = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		vstd[N] = true;
		queue.add(new int[] { N, 0 });

		while (!queue.isEmpty()) {
			int[] crnt = queue.poll();

			X = crnt[0];
			sec = crnt[1];

			if (X == K) {
				bw.write(sec + "\n");
				bw.flush();
				break;
			}

			if (X - 1 >= 0 && !vstd[X - 1]) {
				vstd[X - 1] = true;
				queue.add(new int[] { X - 1, sec + 1 });
			}

			if (X + 1 <= 100000 && !vstd[X + 1]) {
				vstd[X + 1] = true;
				queue.add(new int[] { X + 1, sec + 1 });
			}

			if (X * 2 <= 100000 && !vstd[X * 2]) {
				vstd[X * 2] = true;
				queue.add(new int[] { X * 2, sec + 1 });
			}
		}
	}

}
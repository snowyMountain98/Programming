import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>();
		long max, width, hght;
		int[] h;
		int n;

		do {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			h = new int[n];
			for (int i = 0; i < n; i++)
				h[i] = Integer.parseInt(st.nextToken());

			max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && h[i] <= h[stack.peek()]) {
					hght = h[stack.pop()];
					width = stack.isEmpty() ? i : i - 1 - stack.peek();
					max = Math.max(max, width * hght);
				}

				stack.push(i);
			}

			while (!stack.isEmpty()) {
				hght = h[stack.pop()];
				width = stack.isEmpty() ? n : n - 1 - stack.peek();
				max = Math.max(max, width * hght);
			}

			bw.write(max + "\n");
			bw.flush();
		} while (true);

		/************************************************************
		 *       ┌─┐
		 *     ┌─┤ │
		 *     │ │ │ ┌─┬─┐
		 * ┌─┐ │ │ │ │ │ │
		 * │ ├─┤ │ ├─┤ │ │
		 * └─┴─┴─┴─┴─┴─┴─┘
		 *  0 1 2 3 4 5 6
		 *  
		 * stack :
		 * │   │   │   │   │   │   ├───┤   │   │   │   │   │   │
		 * │   │   │   │   │   │   │ 3 │   │   │   │   │   │   │
		 * │   │   │   │   ├───┤   ├───┤   │   │   ├───┤   ├───┤
		 * │   │ > │   │ > │ 2 │ > │ 2 │ > │   │ > │ 5 │ > │ 6 │
		 * ├───┤   ├───┤   ├───┤   ├───┤   ├───┤   ├───┤   ├───┤
		 * │ 0 │   │ 1 │   │ 1 │   │ 1 │   │ 4 │   │ 4 │   │ 4 │
		 * └───┘   └───┘   └───┘   └───┘   └───┘   └───┘   └───┘
		 ************************************************************/
	}

}
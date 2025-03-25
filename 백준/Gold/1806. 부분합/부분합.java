import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, S, start, end, sum = 0, min = Integer.MAX_VALUE;
		int[] sqnc;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		sqnc = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			sqnc[i] = Integer.parseInt(st.nextToken());

		start = 0;
		end = 0;

		while (start <= N && end <= N) {
			if (sum >= S && min > end - start)
				min = end - start;

			if (sum < S)
				sum += sqnc[end++];
			else
				sum -= sqnc[start++];
		}

		/************************************************************
		 *   0   1   2   3   4   5   6   7   8   9
		 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
		 * │ 5 │ 1 │ 3 │ 5 │ 10│ 7 │ 4 │ 9 │ 2 │ 8 │    sum │ min
		 * └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘   ─────┼─────
		 *   ↑                   ↑                       24 │ 5
		 *       ↑               ↑                       19 │ 4
		 *           ↑           ↑                       18 │ 3
		 *               ↑       ↑                       15 │ 2
		 ************************************************************/

		if (min == Integer.MAX_VALUE)
			min = 0;
		
		bw.write(min + "\n");
		bw.flush();
	}

}
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
		int n;
		int[][] cost, min;

		n = Integer.parseInt(br.readLine());

		cost = new int[n][3];
		min = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}

		min[0][0] = cost[0][0];
		min[0][1] = cost[0][1];
		min[0][2] = cost[0][2];

		for (int i = 1; i < n; i++) {
			min[i][0] = cost[i][0] + Math.min(min[i - 1][1], min[i - 1][2]);
			min[i][1] = cost[i][1] + Math.min(min[i - 1][0], min[i - 1][2]);
			min[i][2] = cost[i][2] + Math.min(min[i - 1][0], min[i - 1][1]);
		}

		bw.write(Math.min(Math.min(min[n - 1][0], min[n - 1][1]), min[n - 1][2]) + "\n");
		bw.flush();
	}

}
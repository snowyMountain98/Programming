import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] cnctn; /* 컴퓨터의 번호 쌍 */
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cmptr /* 컴퓨터의 수 */, pairs /* 컴퓨터 쌍의 수 */, x, y, virus = 0;

		cmptr = Integer.parseInt(br.readLine());
		pairs = Integer.parseInt(br.readLine());

		cnctn = new ArrayList[cmptr + 1];
		visited = new boolean[cmptr + 1];

		for (int i = 1; i <= cmptr; i++)
			cnctn[i] = new ArrayList<>();

		for (int i = 0; i < pairs; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			cnctn[x].add(y);
			cnctn[y].add(x);
		}
		
		visited[1] = true;
		dfs(1);

		for (int i = 2; i <= cmptr; i++) {
			if (visited[i])
				virus++;
		}

		bw.write(virus + "\n");
		bw.flush();
	}

	public static void dfs(int v) {
		for (int i : cnctn[v]) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

}
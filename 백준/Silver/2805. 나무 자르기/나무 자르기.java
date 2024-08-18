import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M;
		long low = 0, hgh = 0, mid;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			hgh = Math.max(hgh, tree[i]);
		}

		while (low <= hgh) {
			mid = (low + hgh) / 2;
			
			if (cutTree(mid) < M)
				hgh = mid - 1;
			else
				low = mid + 1;
		}

		bw.write(hgh + "\n");
		bw.flush();
	}

	public static long cutTree(long hght) {
		long num = 0;

		for (int i = 0; i < tree.length; i++)
			num += tree[i] - hght > 0 ? tree[i] - hght : 0;

		return num;
	}

}
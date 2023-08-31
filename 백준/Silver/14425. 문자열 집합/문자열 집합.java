import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, m, cnt = 0;
		Set<String> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++)
			set.add(br.readLine());

		for (int i = 0; i < m; i++) {
			if (set.contains(br.readLine()))
				cnt++;
		}

		System.out.println(cnt);
	}

}
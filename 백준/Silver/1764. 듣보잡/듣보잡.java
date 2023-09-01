import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String, Integer> map = new HashMap<>();
		List<String> deutbojap = new ArrayList<>();
		StringTokenizer st;
		int n, m;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n + m; i++) {
			String name = br.readLine();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		/**********************************************************************
		 * map : {ohhenrie=2, obama=1, clinton=1, baesangwook=2, charlie=1}
		 **********************************************************************/

		for (String key : map.keySet()) {
			if (map.get(key) > 1)
				deutbojap.add(key);
		}

		Collections.sort(deutbojap);

		bw.write(deutbojap.size() + "\n");
		for (int i = 0; i < deutbojap.size(); i++)
			bw.write(deutbojap.get(i) + "\n");

		bw.flush();
	}

}
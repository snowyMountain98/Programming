import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Map<String, Integer> map = new HashMap<>();
		List<String> list;
		int n, m;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		while (n > 0) {
			String word = br.readLine();

			if (word.length() < m) {
				n--;
				continue;
			}

			map.put(word, map.getOrDefault(word, 0) + 1);

			n--;
		}

		/****************************************
		 * map : {apple=2, sand=3, append=1}
		 ****************************************/

		list = new ArrayList<>(map.keySet());

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (map.get(s1) == map.get(s2)) {
					/* 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치 */
					if (s1.length() == s2.length())
						return s1.compareTo(s2);
					/* 해당 단어의 길이가 길수록 앞에 배치 */
					else
						return s2.length() - s1.length();
				}
				/* 자주 나오는 단어일수록 앞에 배치 */
				else
					return map.get(s2) - map.get(s1);
			}

		});

		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + "\n");

		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, sum = 0;
		String[] word;
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> cnt = new HashMap<>();
		ArrayList<Character> ch = new ArrayList<>();

		N = Integer.parseInt(br.readLine());

		word = new String[N];

		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();

			for (int j = 0; j < word[i].length(); j++) {
				char c = word[i].charAt(j);
				/* 자릿수에 따른 가중치 누적 */
				cnt.put(c, (int) (cnt.getOrDefault(c, 0) + Math.pow(10, word[i].length() - j)));

				/* 문자 목록에 없으면 추가 */
				if (!ch.contains(c))
					ch.add(c);
			}
		}

		/**
		 * word: [GCF, ACDEB]
		 * cnt: {A=100000, B=10, C=10100, D=1000, E=100, F=10, G=1000}
		 */

		/* 문자들을 가중치(cnt) 기준으로 내림차순 정렬 */
		Collections.sort(ch, new Comparator<>() {
			@Override
			public int compare(Character o1, Character o2) {
				return Integer.compare(cnt.get(o2), cnt.get(o1));
			}
		});

		/**
		 * ch: [A, C, G, D, E, F, B]
		 */

		int num = 9;

		/* 가장 큰 가중치를 가진 문자부터 9, 8, 7 ... 할당 */
		for (int i = 0; i < ch.size(); i++) {
			map.put(ch.get(i), num);
			num--;
		}

		/**
		 * map: {A=9, B=3, C=8, D=6, E=5, F=4, G=7}
		 */

		/* 각 단어를 숫자로 변환하여 합산 */
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < word[i].length(); j++)
				sb.append(map.get(word[i].charAt(j)));

			sum += Integer.parseInt(sb.toString());
		}

		bw.write(sum + "\n");
		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, n, cases;
		Iterator<String> keys;
		Map<String, ArrayList<String>> clths;
		String name, ctgry;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			n = Integer.parseInt(br.readLine());
			clths = new HashMap<>();
			cases = 1;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				name = st.nextToken();
				ctgry = st.nextToken();

				if (!clths.containsKey(ctgry))
					clths.put(ctgry, new ArrayList<>());

				clths.get(ctgry).add(name);
			}

			/************************************************************
			 * clths : {eyewear=[sunglasses], headgear=[hat, turban]}
			 ************************************************************/

			/* 각 의상 종류에 대해 조합 계산 */
			keys = clths.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				cases *= (clths.get(key).size() + 1);	// 해당 카테고리에서 선택하는 경우의 수 (+1은 착용하지 않는 경우 포함)
			}

			cases--;	// 아무것도 착용하지 않는 경우 제외
			bw.write(cases + "\n");

			T--;
		}

		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String, Integer> card = new HashMap<>();
		StringTokenizer st;
		int n, m;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			String num = st.nextToken();
			card.put(num, card.getOrDefault(num, 0) + 1);
		}

		/**************************************************
		 * card : {2=1, 3=2, 6=1, 7=1, -10=2, 10=3}
		 **************************************************/

		m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			bw.write(card.getOrDefault(st.nextToken(), 0) + " ");

		bw.flush();
	}

}
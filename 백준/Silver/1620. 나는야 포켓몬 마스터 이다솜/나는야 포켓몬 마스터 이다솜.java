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
		StringTokenizer st;
		int n, m;
		Map<String, String> name = new HashMap<>();
		Map<String, String> num = new HashMap<>();
		String pokemon, question;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			pokemon = br.readLine();
			name.put(Integer.toString(i + 1), pokemon);	// <번호, 이름>
			num.put(pokemon, Integer.toString(i + 1));	// <이름, 번호>
		}

		for (int i = 0; i < m; i++) {
			question = br.readLine();
			bw.write(name.getOrDefault(question, num.get(question)) + "\n");
		}

		bw.flush();
	}

}
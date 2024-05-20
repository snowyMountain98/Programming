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
		int q, l, r, len;
		int[][] alphabet;
		String s;
		char a;

		s = br.readLine();
		len = s.length();
		alphabet = new int[26][len];

		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < len; j++) {
				if (i == s.charAt(j) - 'a')
					alphabet[i][j] = j == 0 ? 1 : alphabet[i][j - 1] + 1;
				else
					alphabet[i][j] = j == 0 ? 0 : alphabet[i][j - 1];
			}
		}

		/************************************************************
		 *   │ s │ e │ u │ n │ g │ j │ a │ e │ h │ w │ a │ n │ g
		 * ──┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───
		 * a │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 2 │ 2 │ 2
		 * e │ 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 2 │ 2 │ 2 │ 2 │ 2 │ 2
		 * g │ 0 │ 0 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 2
		 * h │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1
		 * j │ 0 │ 0 │ 0 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1
		 * n │ 0 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 2 │ 2
		 * s │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1
		 * u │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1
		 * w │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1
		 ************************************************************/

		q = Integer.parseInt(br.readLine());

		while (q > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = st.nextToken().charAt(0);
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			bw.write((l == 0 ? alphabet[a - 'a'][r] : alphabet[a - 'a'][r] - alphabet[a - 'a'][l - 1]) + "\n");

			q--;
		}

		bw.flush();
		bw.close();
	}

}
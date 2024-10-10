import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, count;
		String word;
		boolean[] alphb;

		N = Integer.parseInt(br.readLine());
		count = N;

		while (N > 0) {
			word = br.readLine();

			alphb = new boolean[26];
			alphb[word.charAt(0) - 'a'] = true;

			for (int i = 1; i < word.length(); i++) {
				if (word.charAt(i) != word.charAt(i - 1)) {
					if (alphb[word.charAt(i) - 'a']) {
						count--;
						break;
					} else
						alphb[word.charAt(i) - 'a'] = true;
				}
			}

			N--;
		}

		bw.write(count + "\n");
		bw.flush();
	}

}
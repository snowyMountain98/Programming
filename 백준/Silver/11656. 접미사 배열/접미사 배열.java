import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S;
		ArrayList<String> suffix = new ArrayList<>();

		S = br.readLine();

		for (int i = 0; i < S.length(); i++)
			suffix.add(S.substring(i));

		Collections.sort(suffix);

		for (int i = 0; i < suffix.size(); i++)
			bw.write(suffix.get(i) + "\n");
		bw.flush();
	}

}
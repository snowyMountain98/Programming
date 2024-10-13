import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word;

		word = br.readLine();

		word = word.replaceAll("c=", "A");
		word = word.replaceAll("c-", "A");
		word = word.replaceAll("dz=", "A");
		word = word.replaceAll("d-", "A");
		word = word.replaceAll("lj", "A");
		word = word.replaceAll("nj", "A");
		word = word.replaceAll("s=", "A");
		word = word.replaceAll("z=", "A");

		bw.write(word.length() + "\n");
		bw.flush();
	}

}
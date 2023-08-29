import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		List<Integer> num = new ArrayList<>();

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++)
			num.add(Integer.parseInt(br.readLine()));

		Collections.sort(num);

		for (int i = 0; i < n; i++)
			bw.write(num.get(i) + "\n");

		bw.flush();
	}

}
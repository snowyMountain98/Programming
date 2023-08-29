import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n;
		int[] num = new int[10001];

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++)
			num[Integer.parseInt(br.readLine())]++;

		for (int i = 1; i < 10001; i++) {
			while (num[i] > 0) {
				sb.append(i + "\n");
				num[i]--;
			}
		}

		System.out.println(sb);
	}

}
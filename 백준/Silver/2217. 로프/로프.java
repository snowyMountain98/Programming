import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, max = Integer.MIN_VALUE;
		int[] rope;

		N = Integer.parseInt(br.readLine());

		rope = new int[N];
		for (int i = 0; i < N; i++)
			rope[i] = Integer.parseInt(br.readLine());

		Arrays.sort(rope);

		for (int i = 0; i < N; i++) {
			rope[i] *= N - i;
			max = Math.max(max, rope[i]);
		}

		bw.write(max + "\n");
		bw.flush();
	}

}
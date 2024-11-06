import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, min = 0;
		Integer[] A, B;

		N = Integer.parseInt(br.readLine());

		A = new Integer[N];
		B = new Integer[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A, Collections.reverseOrder());
		Arrays.sort(B);

		for (int i = 0; i < N; i++)
			min += A[i] * B[i];

		bw.write(min + "\n");
		bw.flush();
	}

}
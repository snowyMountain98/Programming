import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N, M;
		int[] A, B, AB;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			B[i] = Integer.parseInt(st.nextToken());

		AB = new int[N + M];

		for (int i = 0; i < N; i++)
			AB[i] = A[i];

		for (int i = N; i < M + N; i++)
			AB[i] = B[i - N];

		Arrays.sort(AB);

		for (int i = 0; i < AB.length; i++)
			bw.write(AB[i] + " ");
		bw.write("\n");
		bw.flush();
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String[] A, B;
		List<String> answer = new ArrayList<>();
		int n, m;

		/* 첫째 줄에 queuestack을 구성하는 자료구조의 개수 N */
		n = Integer.parseInt(br.readLine());

		A = new String[n];
		B = new String[n];

		/* 둘째 줄에 길이 N의 수열 A */
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			A[i] = st.nextToken();

		/* 셋째 줄에 길이 N의 수열 B */
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			B[i] = st.nextToken();

		for (int i = n - 1; i >= 0; i--) {
			if ("0".equals(A[i]))
				answer.add(B[i]);
		}

		/* 넷째 줄에 삽입할 수열의 길이 M */
		m = Integer.parseInt(br.readLine());

		/* 다섯째 줄에 queuestack에 삽입할 원소를 담고 있는 길이 M의 수열 C */
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			answer.add(st.nextToken());
		}
		
		/******************************
		 *  4
		 * ┌─┐     ┌─┐
		 * │0│ 1 1 │0│	→ 큐인 것만
		 * │1│ 2 3 │4│
		 * └─┘     └─┘
		 *  3
		 * ┌─────┐
		 * │2 4 7│		→ 입력
		 * └─────┘
		 ******************************/

		for (int i = 0; i < m; i++)
			bw.write(answer.get(i) + " ");

		bw.flush();
	}

}
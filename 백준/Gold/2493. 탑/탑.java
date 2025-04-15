import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int[] tower, rcv;
		Stack<Integer> stc = new Stack<>();

		N = Integer.parseInt(br.readLine());

		tower = new int[N + 1];
		rcv = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			tower[i] = Integer.parseInt(st.nextToken());

		/* 오른쪽에서 왼쪽으로 탐색하며 신호를 받는 타워를 찾음 */
		for (int i = N; i >= 0; i--) {
			/* 현재 타워(tower[i])보다 낮은 타워들은 신호를 줄 수 있으므로 스택에서 제거 */
			while (!stc.isEmpty() && tower[i] > tower[stc.peek()])
				rcv[stc.pop()] = i;	// 신호를 받는 타워 인덱스 저장

			stc.push(i);	// 현재 타워를 스택에 추가
		}

		for (int i = 1; i <= N; i++)
			bw.write(rcv[i] + " ");
		bw.write("\n");

		bw.flush();
	}

}
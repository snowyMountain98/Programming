import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		int[][] time;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();	// 현재 사용 중인 강의실들의 종료 시간을 저장

		N = Integer.parseInt(br.readLine());

		time = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		/* 강의를 시작 시간 기준으로 정렬
		 * 시작 시간이 같으면 종료 시간이 빠른 순으로 정렬 */
		Arrays.sort(time, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return Integer.compare(o1[1], o2[1]);
				else
					return Integer.compare(o1[0], o2[0]);
			}
		});

		/* 정렬된 강의를 순서대로 처리 */
		for (int i = 0; i < N; i++) {
			/* 가장 빨리 끝나는 강의의 종료 시간과 현재 강의의 시작 시간을 비교 */
			if (!pQ.isEmpty() && time[i][0] >= pQ.peek()) {
				/* 기존 강의실 재사용 가능 */
				pQ.poll();
				pQ.offer(time[i][1]);
			} else {
				/* 새 강의실이 필요함 */
				pQ.offer(time[i][1]);
			}
		}

		bw.write(pQ.size() + "\n");
		bw.flush();
	}

}
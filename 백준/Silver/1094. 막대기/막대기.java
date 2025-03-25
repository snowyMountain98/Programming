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
		int X;
		ArrayList<Integer> stick = new ArrayList<>();

		X = Integer.parseInt(br.readLine());
		stick.add(64);

		/* 합이 X보다 크다면, 아래와 같은 과정을 반복 */
		while (X < sum(stick)) {
			/* 막대기 리스트를 정렬 (오름차순) */
			Collections.sort(stick);

			/* 가장 짧은 막대기를 선택 */
			int min = stick.get(0);

			/* 가장 짧은 막대기를 리스트에서 제거 */
			stick.remove(0);
			/* 선택한 막대기를 절반으로 나눠 두 개 추가 */
			stick.add(0, min / 2);
			stick.add(0, min / 2);

			/* 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 X보다 크거나 같다면 */
			if (X <= sum(stick) - min / 2)
				/* 위에서 자른 막대의 절반 중 하나를 제거 */
				stick.remove(0);

			bw.flush();
		}

		bw.write(stick.size() + "\n");
		bw.flush();
	}

	/* 리스트에 있는 막대기 길이들의 총합을 계산 */
	public static int sum(ArrayList<Integer> stick) {
		int sum = 0;

		for (int i : stick)
			sum += i;

		return sum;
	}
}
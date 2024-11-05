import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, x1, y1, r1, x2, y2, r2, d, sum, diff;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			/* 두 원의 중심 거리의 제곱 */
			d = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			/* 두 원의 반지름 합의 제곱 */
			sum = (int) Math.pow(r1 + r2, 2);
			/* 두 원의 반지름 차의 제곱 */
			diff = (int) Math.pow(r1 - r2, 2);

			/* 두 원이 완전히 겹치는 경우 */
			if (d == 0 && r1 == r2)
				bw.write("-1\n");
			/* 두 원이 만나지 않는 경우 */
			else if (d < diff || d > sum)
				bw.write("0\n");
			/* 두 원이 한 점에서 만나는 경우 */
			else if (d == diff || d == sum)
				bw.write("1\n");
			/* 두 원이 두 점에서 만나는 경우 */
			else if (d > diff && d < sum)
				bw.write("2\n");

			bw.flush();

			T--;
		}
	}

}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static class Planet {
		int x, y, r;

		public Planet(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T, n, cnt;
		int[] start = new int[2], end = new int[2];
		Planet[] plnt;

		T = Integer.parseInt(br.readLine());

		while (T > 0) {
			st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());

			n = Integer.parseInt(br.readLine());

			plnt = new Planet[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				plnt[i] = new Planet(
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			cnt = 0;

			/* 각 행성계를 확인하면서 시작점과 도착점 중 하나만 포함하는 경우 count */
			for (Planet p : plnt) {
				if (isInside(start, p) && !isInside(end, p))
					cnt++;
				else if (!isInside(start, p) && isInside(end, p))
					cnt++;
			}

			bw.write(cnt + "\n");

			T--;
		}

		bw.flush();
	}

	public static boolean isInside(int[] a, Planet b) {
		double dstnc;

		/* 유클리드 거리 계산 */
		dstnc = Math.sqrt(Math.pow(a[0] - b.x, 2) + Math.pow(a[1] - b.y, 2));

		/* 거리가 반지름보다 작으면 내부에 있음 */
		if (dstnc < b.r)
			return true;
		else
			return false;
	}

}
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N, endT = 0, cnt = 0;
		int[][] meeting;

		N = scn.nextInt();
		meeting = new int[N][2];

		for (int i = 0; i < N; i++) {
			meeting[i][0] = scn.nextInt();
			meeting[i][1] = scn.nextInt();
		}

		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return Integer.compare(o1[0], o2[0]);
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		/**********************************************************************
		 * ┃   │   │   │   │   │   │   │   │   │   │   │   │   │   │   │
		 * ┃   │   │   │   │   │   │   │   │   │   │   │   ┣━━━┿━━━┫   │
		 * ┃   │   ┣━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┿━━━┫   │   │
		 * ┃   │   │   │   │   │   │   │   ┣━━━┿━━━┿━━━┿━━━┫   │   │   │
		 * ┃   │   │   │   │   │   │   │   ┣━━━┿━━━┿━━━┫   │   │   │   │
		 * ┃   │   │   │   │   │   ┣━━━┿━━━┿━━━┿━━━┫   │   │   │   │   │
		 * ┃   │   │   │   │   ┣━━━┿━━━┿━━━┿━━━┫   │   │   │   │   │   │
		 * ┃   │   │   ┣━━━┿━━━┿━━━┿━━━┿━━━┫   │   │   │   │   │   │   │
		 * ┃   │   │   │   │   ┣━━━┿━━━┫   │   │   │   │   │   │   │   │
		 * ┣━━━┿━━━┿━━━┿━━━┿━━━┿━━━┫   │   │   │   │   │   │   │   │   │
		 * ┃   │   │   ┣━━━┿━━━┫   │   │   │   │   │   │   │   │   │   │
		 * ┃   ┣━━━┿━━━┿━━━┫   │   │   │   │   │   │   │   │   │   │   │
		 * ╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━
		 * ┃0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
		 **********************************************************************/


		for (int i = 0; i < N; i++) {
			if (endT <= meeting[i][0]) {
				cnt++;
				endT = meeting[i][1];
			}
		}

		System.out.println(cnt);
	}

}
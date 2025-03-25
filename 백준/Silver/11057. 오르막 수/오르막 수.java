import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;
		int[][] uphilNum;

		N = Integer.parseInt(br.readLine());
		uphilNum = new int[N + 1][10];

		for (int i = 0; i < 10; i++)
			uphilNum[0][i] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 10; j++)
				for (int k = j; k < 10; k++)
					uphilNum[i][j] = (uphilNum[i][j] + uphilNum[i - 1][k]) % 10007;
		}

		/**************************************************
		 * uphilNum :
		 *   ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
		 * 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │ 1 │
		 *   ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤	
		 * 1 │ 10│ 9 │ 8 │ 7 │ 6 │ 5 │ 4 │ 3 │ 2 │ 1 │
		 *   ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
		 * 2 │ 55│ 45│ 36│ 28│ 21│ 15│ 10│ 6 │ 3 │ 1 │
		 *   ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
		 * 3 │220│165│120│ 84│ 56│ 35│ 20│ 10│ 4 │ 1 │
		 *   └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
		 **************************************************/

		bw.write(uphilNum[N][0] + "\n");
		bw.flush();
	}

}
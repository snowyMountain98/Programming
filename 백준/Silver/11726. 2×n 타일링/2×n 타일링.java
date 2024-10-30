import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] tiling = new int[1001];
		;

		n = Integer.parseInt(br.readLine());

		tiling[1] = 1;
		tiling[2] = 2;

		for (int i = 3; i <= n; i++)
			tiling[i] = (tiling[i - 1] + tiling[i - 2]) % 10007;

		/**************************************************
		 * tiling[i - 2]	tiling[i - 1]
		 * ┌─┬─┬─┲━━━┓		┌─┬─┬─┬─┲━┓
		 * │ │ │ ┣━━━┫		│ │ │ │ ┃ ┃
		 * └─┴─┴─┺━━━┛		└─┴─┴─┴─┺━┛
		 * ┌─┬───┲━━━┓		┌───┬───┲━┓
		 * │ ├───╊━━━┫		├───┼───┨ ┃
		 * └─┴───┺━━━┛		└───┴───┺━┛
		 * ┌───┬─┲━━━┓		┌─┬───┬─┲━┓
		 * ├───┤ ┣━━━┫		│ ├───┤ ┃ ┃
		 * └───┴─┺━━━┛		└─┴───┴─┺━┛
		 * 			┌─┬─┬───┲━┓
		 * 			│ │ ├───┨ ┃
		 * 			└─┴─┴───┺━┛
		 * 			┌───┬─┬─┲━┓
		 * 			├───┤ │ ┃ ┃
		 * 			└───┴─┴─┺━┛
		 **************************************************/

		bw.write(tiling[n] + "\n");
		bw.flush();
	}

}

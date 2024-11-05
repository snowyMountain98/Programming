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
		int[] tlng;

		n = Integer.parseInt(br.readLine());
		tlng = new int[1001];

		tlng[1] = 1;
		tlng[2] = 3;

		for (int i = 3; i <= n; i++)
			tlng[i] = (tlng[i - 1] + tlng[i - 2] * 2) % 10007;

		/**************************************************
		 * tlng[i - 2]
		 * ┌─┬─┲━━━┓    ┌─┬─┲━━━┓
		 * │ │ ┣━━━┫    │ │ ┃   ┃
		 * └─┴─┺━━━┛    └─┴─┺━━━┛
		 * ┌───┲━━━┓    ┌───┲━━━┓
		 * ├───╊━━━┫    ├───┨   ┃
		 * └───┺━━━┛    └───┺━━━┛
		 * ┌───┲━━━┓    ┌───┲━━━┓
		 * │   ┣━━━┫    │   ┃   ┃
		 * └───┺━━━┛    └───┺━━━┛
		 * tlng[i - 1]
		 * ┌─┬───┲━┓    ┌─┬─┬─┲━┓
		 * │ │   ┃ ┃    │ │ │ ┃ ┃
		 * └─┴───┺━┛    └─┴─┴─┺━┛
		 * ┌───┬─┲━┓    ┌───┬─┲━┓
		 * ├───┤ ┃ ┃    │   │ ┃ ┃
		 * └───┴─┺━┛    └───┴─┺━┛
		 **************************************************/

		bw.write(tlng[n] + "\n");
		bw.flush();
	}

}
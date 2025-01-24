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
		int[] A, NGE;
		Stack<Integer> stack = new Stack<>();

		N = Integer.parseInt(br.readLine());

		A = new int[N];
		NGE = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
				NGE[stack.pop()] = A[i];
			}

			stack.push(i);
		}

		while (!stack.isEmpty()) {
			NGE[stack.pop()] = -1;
		}
		
		/****************************************************************************************************
		 * N = 4
		 * A = [3, 5, 2, 7]
		 * 
		 * i : 1				│   │		i : 2				│   │
		 * 						│   │							│   │
		 * ┌───┬───┬───┬───┐	┢━━━┪	→	┏━━━┱───┬───┬───┐	┢━━━┪	→
		 * │ 0 │ 0 │ 0 │ 0 │	┃ 1 ┃		┃ 5 ┃ 0 │ 0 │ 0 │	┃ 2 ┃
		 * └───┴───┴───┴───┘	┗━━━┛		┗━━━┹───┴───┴───┘	┗━━━┛
		 * 
		 * i : 3				┢━━━┪		i : 4				│   │							│   │
		 * 						┃ 3 ┃							│   │							│   │
		 * ┌───┬───┬───┬───┐	┡━━━┩	→	┌───┲━━━┳━━━┱───┐	┢━━━┪	→	┌───┬───┬───┲━━━┓	│   │
		 * │ 5 │ 0 │ 0 │ 0 │	│ 2 │		│ 5 ┃ 7 ┃ 7 ┃ 0 │	┃ 4 ┃		│ 5 │ 7 │ 7 ┃ -1┃	│   │
		 * └───┴───┴───┴───┘	└───┘		└───┺━━━┻━━━┹───┘	┗━━━┛		└───┴───┴───┺━━━┛	└───┘
		 * 
		 * 
		 * 
		 ****************************************************************************************************/

		for (int i = 0; i < N; i++)
			bw.write(NGE[i] + " ");
		bw.write("\n");

		bw.flush();
	}

}
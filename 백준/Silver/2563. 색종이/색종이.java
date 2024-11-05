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
		int N, area = 0;
		int[][] clrdPaper;
		boolean[][] dohwaji = new boolean[101][101];

		N = Integer.parseInt(br.readLine());

		clrdPaper = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			clrdPaper[i][0] = Integer.parseInt(st.nextToken());
			clrdPaper[i][1] = Integer.parseInt(st.nextToken());
		}

		/* 색종이의 영역을 도화지에 표시 */
		for (int i = 0; i < N; i++) {
			/* 색종이의 높이(10)와 너비(10)를 더하여 도화지의 영역에 true로 설정 */
			for (int j = clrdPaper[i][1]; j < clrdPaper[i][1] + 10; j++)
				for (int k = clrdPaper[i][0]; k < clrdPaper[i][0] + 10; k++)
					dohwaji[j][k] = true;
		}

		/* 도화지에서 true로 표시된 영역의 수를 계산하여 면적(area)에 추가 */
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++)
				if (dohwaji[i][j])
					area++;
		}

		bw.write(area + "\n");
		bw.flush();
	}

}
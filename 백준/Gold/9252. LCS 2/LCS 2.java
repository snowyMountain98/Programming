import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] dp;
		String str1, str2;
		StringBuilder sb = new StringBuilder();

		str1 = br.readLine();
		str2 = br.readLine();

		dp = new int[str1.length() + 1][str2.length() + 1];

		/**
		 * DP 채우기
		 */
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				/* 현재 문자가 같다면, 이전 대각선 값 + 1 */
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				/* 다르다면 위쪽이나 왼쪽 중 더 큰 값 선택 */
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int y = str1.length(), x = str2.length();

		/**
		 * DP를 역추적하여 실제 LCS 문자열을 복원
		 */
		while (y > 0 && x > 0) {
			/* 왼쪽과 위쪽의 값이 같다면 문자를 추가하고 대각선으로 이동 */
			if (str1.charAt(y - 1) == str2.charAt(x - 1)) {
				sb = sb.append(str1.charAt(y - 1));
				y--;
				x--;
			}
			/* 왼쪽 값이 더 크면 왼쪽으로 이동 */
			else if (dp[y][x - 1] > dp[y - 1][x])
				x--;
			/* 위쪽 값이 더 크면 위로 이동 */
			else
				y--;
		}

		bw.write(dp[str1.length()][str2.length()] + "\n");
		if (dp[str1.length()][str2.length()] != 0)
			bw.write(sb.reverse().toString() + "\n");
		bw.flush();
	}

}
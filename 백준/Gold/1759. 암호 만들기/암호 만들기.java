import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int L;
	static char[] ch;
	static StringBuilder sb;
	static ArrayList<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int C;

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		ch = br.readLine().replaceAll(" ", "").toCharArray();
		Arrays.sort(ch);

		for (int i = 0; i < ch.length; i++) {
			sb = new StringBuilder();
			sb.append(ch[i]);
			dfs(i + 1);
		}

		bw.flush();
	}

	/**************************************************
	 * DFS(깊이 우선 탐색)
	 **************************************************/
	public static void dfs(int start) throws IOException {
		if (sb.length() == L && probable(sb.toString())) {
			bw.write(sb.toString() + "\n");
			return;
		}

		for (int i = start; i < ch.length; i++) {
			sb.append(ch[i]);
			dfs(i + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	/**************************************************
	 * 암호 조건을 만족하는지 검사
	 **************************************************/
	public static boolean probable(String pswrd) {
		int vowelCnt = 0, cnsnnCnt = 0;

		for (int i = 0; i < pswrd.length(); i++) {
			if (vowel.contains(pswrd.charAt(i)))
				vowelCnt++;
			else
				cnsnnCnt++;
		}

		/* 최소 한 개의 모음과 최소 두 개의 자음으로 구성 */
		if (vowelCnt >= 1 && cnsnnCnt >= 2)
			return true;
		else
			return false;
	}
}
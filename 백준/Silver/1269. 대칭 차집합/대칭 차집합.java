import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> symDfr = new HashSet<>();	// 대칭 차집합
		StringTokenizer st;
		int a, b;

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			String e = st.nextToken();
			symDfr.add(e);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			String e = st.nextToken();
			if (symDfr.contains(e))
				symDfr.remove(e);
			else
				symDfr.add(e);
		}

		System.out.println(symDfr.size());
	}

}
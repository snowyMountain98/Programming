import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] accessRecord = br.readLine().split(" ");

			/* "enter"인 경우는 출근 */
			if ("enter".equals(accessRecord[1]))
				set.add(accessRecord[0]);
			/* "leave"인 경우는 퇴근 */
			else
				set.remove(accessRecord[0]);
		}

		list = new ArrayList<>(set);

		/* 사전 순의 역순 */
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + "\n");

		bw.flush();
	}

}
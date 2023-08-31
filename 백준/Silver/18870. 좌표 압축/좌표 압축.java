import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int[] x;
		Set<Integer> set = new HashSet<>();
		List<Integer> list;
		Map<Integer, Integer> map = new HashMap<>();

		n = scn.nextInt();

		x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = scn.nextInt();
			set.add(x[i]);
		}
		/****************************************
		 * x : [2, 4, -10, 4, -9]
		 * set : [2, 4, -9, -10]
		 ****************************************/

		list = new ArrayList<>(set);
		Collections.sort(list);
		/****************************************
		 * list : [-10, -9, 2, 4]
		 ****************************************/

		for (int i = 0; i < list.size(); i++)
			map.put(list.get(i), i);
		/****************************************
		 * map : {2=2, 4=3, -9=1, -10=0}
		 ****************************************/

		for (int i = 0; i < n; i++)
			bw.write(map.get(x[i]) + " ");

		bw.flush();

		scn.close();
	}

}
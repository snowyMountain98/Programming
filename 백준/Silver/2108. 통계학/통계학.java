import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Map<Integer, Integer> map = new LinkedHashMap<>();
		List<Integer> list = new ArrayList<>();
		int[] num;
		int n, sum = 0, max = 0;

		n = scn.nextInt();

		num = new int[n];
		for (int i = 0; i < n; i++)
			num[i] = scn.nextInt();

		Arrays.sort(num);

		/* 산술평균 */
		for (int i = 0; i < n; i++)
			sum += num[i];
		System.out.println(Math.round((double) sum / n));

		/* 중앙값 */
		System.out.println(num[n / 2]);

		/* 최빈값 */
		for (int i = 0; i < n; i++) {
			map.put(num[i], map.getOrDefault(num[i], 0) + 1);

			if (max < map.get(num[i]))
				max = map.get(num[i]);
		}

		for (int key : map.keySet()) {
			if (map.get(key) == max)
				list.add(key);
		}

		Collections.sort(list);

		System.out.println(list.get(1 % list.size()));

		/* 범위 */
		System.out.println(num[n - 1] - num[0]);
	}

}
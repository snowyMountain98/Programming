import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] str;
		double crdt = 0, sum = 0;
		Map<String, Double> map = new HashMap<>();

		/* 각 학점에 대한 평점을 맵에 추가 */
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);

		/* 20개의 입력 데이터를 처리 (과목 이름, 학점, 성적 순으로 입력받음) */
		for (int i = 0; i < 20; i++) {
			/* 한 줄 입력 받아 공백으로 나누어 배열에 저장 */
			str = br.readLine().split(" ");

			/* "P"는 Pass 과목이므로 평점 계산에서 제외 */
			if (!"P".equals(str[2])) {
				/* (학점 * 평점)을 누적하여 crdt에 더함 */
				crdt += Double.parseDouble(str[1]) * map.get(str[2]);
				/* 학점을 누적하여 sum에 더함 */
				sum += Double.parseDouble(str[1]);
			}
		}

		bw.write(crdt / sum + "\n");
		bw.flush();
	}

}
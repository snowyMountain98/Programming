import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Student implements Comparable<Student> {
		String name;
		int krn, engls, math;

		Student(String name, int krn, int engls, int math) {
			this.name = name;
			this.krn = krn;
			this.engls = engls;
			this.math = math;
		}

		@Override
		public int compareTo(Student o) {
			if (this.krn == o.krn) {	// 국어 점수가 같으면
				if (this.engls == o.engls) {	// 국어 점수와 영어 점수가 같으면
					if (this.math == o.math)	// 모든 점수가 같으면
						return this.name.compareTo(o.name);	// 이름이 사전 순으로 증가하는 순서
					else
						return Integer.compare(o.math, this.math);	// 수학 점수가 감소하는 순서
				} else
					return Integer.compare(this.engls, o.engls);	// 영어 점수가 증가하는 순서
			} else
				return Integer.compare(o.krn, this.krn);	// 국어 점수가 감소하는 순서
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N;
		PriorityQueue<Student> pQ = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			pQ.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		while (!pQ.isEmpty()) {
			bw.write(pQ.poll().name + "\n");
		}
		bw.flush();
	}
}
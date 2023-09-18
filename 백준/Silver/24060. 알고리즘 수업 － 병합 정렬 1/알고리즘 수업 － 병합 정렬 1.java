import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] A, tmp;
	static List<Integer> store = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, k;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		A = new int[n];
        tmp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(st.nextToken());

		merge_sort(A, 0, A.length - 1);

		if (k - 1 < store.size())
			bw.write(store.get(k - 1) + "\n");
		else
			bw.write("-1\n");

		bw.flush();
	}

	/* A[p..r]을 오름차순 정렬한다 */
	public static void merge_sort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;		// q는 p, r의 중간 지점
			merge_sort(A, p, q);		// 전반부 정렬
			merge_sort(A, q + 1, r);	// 후반부 정렬
			merge(A, p, q, r);			// 병합
		}
	}

	/* A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다 */
	/* A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다 */
	public static void merge(int A[], int p, int q, int r) {
		int i = p, j = q + 1, t = 0;

		while (i <= q && j <= r) {
			if (A[i] <= A[j])
				tmp[t++] = A[i++];
			else
				tmp[t++] = A[j++];
		}

		/* 왼쪽 배열 부분이 남은 경우 */
		while (i <= q)
			tmp[t++] = A[i++];

		/* 오른쪽 배열 부분이 남은 경우 */
		while (j <= r)
			tmp[t++] = A[j++];

		i = p;
		t = 0;

		/* 결과를 A[p..r]에 저장 */
		while (i <= r) {
			store.add(tmp[t]);
			A[i++] = tmp[t++];
		}
	}
}
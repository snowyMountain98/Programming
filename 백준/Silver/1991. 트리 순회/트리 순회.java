import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static StringBuilder sb;
	static Map<String, Node> tree = new HashMap<>();

	/* 노드 클래스 정의 */
	static class Node {
		String key;
		Node left, right;

		Node(String key) {
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");

			tree.putIfAbsent(str[0], new Node(str[0]));

			if (!".".equals(str[1])) {
				tree.get(str[0]).left = new Node(str[1]);
				tree.put(str[1], tree.get(str[0]).left);
			}

			if (!".".equals(str[2])) {
				tree.get(str[0]).right = new Node(str[2]);
				tree.put(str[2], tree.get(str[0]).right);
			}
		}

		/* 전위 순회 결과 출력 */
		sb = new StringBuilder();
		prrdrTrvrs(tree.get("A"));
		bw.write(sb.toString() + "\n");

		/* 중위 순회 결과 출력 */
		sb = new StringBuilder();
		inrdrTrvrs(tree.get("A"));
		bw.write(sb.toString() + "\n");

		/* 후위 순회 결과 출력 */
		sb = new StringBuilder();
		pstrdTrvrs(tree.get("A"));
		bw.write(sb.toString() + "\n");

		bw.flush();
	}

	/* 전위 순회 (Preorder Traversal): 루트 → 왼쪽 → 오른쪽 */
	public static void prrdrTrvrs(Node n) {
		sb.append(n.key);

		if (n.left != null)
			prrdrTrvrs(n.left);

		if (n.right != null)
			prrdrTrvrs(n.right);
	}

	/* 중위 순회 (Inorder Traversal): 왼쪽 → 루트 → 오른쪽 */
	public static void inrdrTrvrs(Node n) {
		if (n.left != null)
			inrdrTrvrs(n.left);

		sb.append(n.key);

		if (n.right != null)
			inrdrTrvrs(n.right);
	}

	/* 후위 순회 (Postorder Traversal): 왼쪽 → 오른쪽 → 루트 */
	public static void pstrdTrvrs(Node n) {
		if (n.left != null)
			pstrdTrvrs(n.left);

		if (n.right != null)
			pstrdTrvrs(n.right);

		sb.append(n.key);
	}

}
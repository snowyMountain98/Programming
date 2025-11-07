import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	/* 이진 탐색 트리의 노드 클래스 */
	static class Node {
		int key;			// 노드의 값
		Node left, right;	// 왼쪽, 오른쪽 자식 노드

		Node(int key) {
			this.key = key;
		}

		/**
		 * 트리에 새로운 값을 삽입
		 */
		void insert(int n) {
			/* 삽입하려는 값이 현재 노드보다 작으면 왼쪽 서브트리로 이동 */
			if (n < this.key) {
				/* 왼쪽 자식이 없으면 새 노드 생성 */
				if (this.left == null)
					this.left = new Node(n);
				/* 왼쪽 자식이 있으면 재귀적으로 삽입 */
				else
					this.left.insert(n);
			}
			/* 삽입하려는 값이 현재 노드보다 크거나 같으면 오른쪽 서브트리로 이동 */
			else {
				/* 오른쪽 자식이 없으면 새 노드 생성 */
				if (this.right == null)
					this.right = new Node(n);
				/* 오른쪽 자식이 있으면 재귀적으로 삽입 */
				else
					this.right.insert(n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Node root;
		String n;

		/* 첫 번째 입력값은 항상 루트 노드가 됨 */
		root = new Node(Integer.parseInt(br.readLine()));

		while ((n = br.readLine()) != null && !n.equals("")) {
			/* 이후 입력값들은 트리에 삽입 */
			root.insert(Integer.parseInt(n));
		}

		/* 후위 순회(postorder traversal) 결과 출력 */
		pstrdTrvrs(root);

		bw.flush();
	}

	/**
	 * 후위 순회(postorder traversal)
	 * 순서: 왼쪽 → 오른쪽 → 루트
	 */
	public static void pstrdTrvrs(Node n) throws IOException {
		/* 왼쪽 서브트리 탐색 */
		if (n.left != null)
			pstrdTrvrs(n.left);

		/* 오른쪽 서브트리 탐색 */
		if (n.right != null)
			pstrdTrvrs(n.right);

		/* 현재 노드의 key를 출력 */
		bw.write(n.key + "\n");
	}

}
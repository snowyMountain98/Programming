import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] selfNmbr = new boolean[10001];

		for (int i = 1; i <= 10000; i++)
			selfNmbr[i] = true;

		for (int i = 1; i <= 10000; i++) {
			if (selfNmbr[i])
				for (int j = d(i); j <= 10000; j = d(j))
					selfNmbr[j] = false;
		}

		for (int i = 1; i <= 10000; i++) {
			if (selfNmbr[i])
				bw.write(i + "\n");
			bw.flush();
		}
	}

	public static int d(int n) {
		int dn = n;

		while (n > 0) {
			dn += n % 10;
			n /= 10;
		}
		
		return dn;
	}

}
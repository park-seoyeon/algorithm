package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603_로또 {

	static int k, S[], number[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = new int[6];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
			
			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println();
		}
	}
	private static void comb(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(number[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < k; i++) {
			number[cnt] = S[i];
			comb(cnt+1, i+1);
		}
	}
	
}

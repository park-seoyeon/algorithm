package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10974_모든순열 {
	
	static int input[], N;
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		perm(0);
	}
	
	private static void perm(int cnt) {
		if (cnt == N) {
			int len = input.length;
			for (int i = 0; i < len; i++) {
				System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			input[cnt] = i+1;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
			
		}
	}
}

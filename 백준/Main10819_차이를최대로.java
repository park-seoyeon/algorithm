package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10819_차이를최대로 {
	
	static int input[], number[], N, max;
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		number = new int[N];
		isSelected = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
		System.out.println(max);
	}
	
	private static void perm(int cnt) {
		int temp = 0;
		if (cnt == N) {
			for (int i = 1; i < N; i++) {
				temp += Math.abs(number[i-1] - number[i]);
			}
			if (temp > max) max = temp; 
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			number[cnt] = input[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}

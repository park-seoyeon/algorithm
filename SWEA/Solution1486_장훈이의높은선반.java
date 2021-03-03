import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1486_장훈이의높은선반 {

	private static int N;
	private static int B;
	private static int[] height;
	private static int min;
	private static int[] input;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			height = new int[N];
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				if (min == 0) break; 
				input = new int[i];
				comb(0,0,i);
			}
			
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		
		System.out.print(sb);
	}

	private static void comb(int cnt, int start, int R) {
		if (cnt == R) {
			int sum = 0;
			int minus = 0;
			for (int i = 0; i < R; i++) {
				sum += input[i];
			}
			
			if (sum >= B) {				
				minus = sum - B;
				min = Math.min(minus, min);
			}
			return;
		}
		
		if (min == 0) return;
		
		for (int i = start; i < N; i++) {
			input[cnt] = height[i];
			comb(cnt+1, i+1, R);
		}
	}
	
}

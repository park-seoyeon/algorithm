import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4012_요리사 {

	static int N, R, answer, dish[][];
	static boolean number[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			R = N/2;
			answer = Integer.MAX_VALUE;
			dish = new int[N][N];
			number = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					dish[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0,0);
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int cal = calc(number);
			answer = Math.min(answer, cal);
			return;
		}
		
		for (int i = start; i < N; i++) {
			number[i] = true;
			comb(cnt+1, i+1);
			number[i] = false;
		}
	}

	private static int calc(boolean[] number) {
		int a = 0;
		int b = 0;
		int cal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if (i == j) continue;
				else if (number[i] && number[j]) {
					a += dish[i][j];
				}
				else if (!number[i] && !number[j]) {
					b += dish[i][j];
				}
			}
		}
		
		cal = Math.abs(a-b);
		return cal;
	}
	
}

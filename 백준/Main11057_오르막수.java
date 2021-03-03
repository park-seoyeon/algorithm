package week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main11057_오르막수 {

	private static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		dp = new int[N+1][10];
		dp[1][0] = dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = dp[1][6] = dp[1][7] = dp[1][8] = dp[1][9] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];
				}
				
				dp[i][j] %= 10007;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			answer += dp[N][i];
		}
		
		System.out.println(answer % 10007);
	}
	
}

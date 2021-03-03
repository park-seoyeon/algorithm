package week15;

import java.util.Scanner;

public class Main1309_동물원 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		if (N == 1) {
			System.out.println(3);
			return;
		}
		else if(N == 2) {
			System.out.println(7);
			return;
		}
		dp[0] = 0;
		dp[1] = 3;
		dp[2] = 7;
		
		for (int i = 3; i < N+1; i++) {
			dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
		}
		
		System.out.println(dp[N]);
	}
	
}

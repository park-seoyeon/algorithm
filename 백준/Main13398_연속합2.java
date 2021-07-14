package new_week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13398_연속합2 {
	
	private static int[] arr = new int[100000];
	private static int[][] dp = new int[100000][2];
	private static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int n = stoi(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		dp[0][0] = arr[0];
		answer = arr[0];
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], arr[i]);
			dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
			answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
		}
		
		System.out.println(answer);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
}

package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1633_최고의팀만들기 {

	private static int[] white = new int[1001];
	private static int[] black = new int[1001];
	private static int[][][] dp = new int[1001][16][16];
	private static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		String line;
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			white[idx] = a;
			black[idx++] = b;;
		}
		
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 16; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		System.out.println(napsack(15,15,0));
	}

	private static int napsack(int w, int b, int now) {	
		if(now == idx)
			return 0;
		
		if (dp[now][w][b] != -1)
			return dp[now][w][b];
		
		if (w > 0)
			dp[now][w][b] = Math.max(dp[now][w][b], napsack(w - 1, b, now + 1) + white[now]);

		if (b > 0)
			dp[now][w][b] = Math.max(dp[now][w][b], napsack(w, b - 1, now + 1) + black[now]);
				
		return dp[now][w][b] = Math.max(dp[now][w][b], napsack(w, b, now + 1));
	}
	
}

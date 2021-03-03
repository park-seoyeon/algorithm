package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10422_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		long dp[] = new long[5001];
		long div = 1000000007L;
		dp[0] = 1;
		dp[2] = 1;
		
		for (int i = 3; i < 5001; i++) {
			for (int j = 2; j <= i; j++) {
				if (j - 2 >= 0 && i - j >= 0) {
					dp[i] += dp[j - 2] * dp[i - j];
					dp[i] %= div;
				}
			}
		}
		
		for (int tc = 0; tc < T; tc++) {
			int num = stoi(br.readLine());
			System.out.println(dp[num]);
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
}

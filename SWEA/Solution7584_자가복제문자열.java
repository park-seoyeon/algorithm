package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution7584_자가복제문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long K = Long.parseLong(br.readLine());
			int answer = find(K);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static int find(long k) {
		if(k == 1)
			return 0;
		long n = 1;
		while (k > n) {
			n *= 2;
		}
		
		if (k == n) {
			return 0;
		}
		else
			return 1-find(n-k);
	}
	
}

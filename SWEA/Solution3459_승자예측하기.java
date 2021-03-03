package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3459_승자예측하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			String answer = "Alice";
			
			while (N > 10) {
				N = (N/2) + 1;
				N = (N/2) - 1;
			}
			if (N == 1 || (N >= 6 && N <= 9)) {
				answer = "Bob";
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
}

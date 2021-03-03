package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3809_화섭이의정수나열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			StringBuilder S = new StringBuilder();
			String nums = "";
			int answer = 0;
			
			while (S.length() < N) {
				S = S.append(br.readLine().replace(" ", ""));
			}
			
			nums = S.toString();
			
			while (true) {
				if (nums.contains(Integer.toString(answer))) 
					answer++;
				else
					break;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

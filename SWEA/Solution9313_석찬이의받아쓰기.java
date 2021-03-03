package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9313_석찬이의받아쓰기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr1 = br.readLine().toCharArray();
			char[] arr2 = br.readLine().toCharArray();
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				if(arr1[i] == arr2[i])
					answer++;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
}

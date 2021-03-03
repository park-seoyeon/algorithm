package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8658_Summation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 10; i++) {
				int n = stoi(st.nextToken());
				int temp = count(n);
				
				if(max < temp)
					max = temp;
				if(min > temp)
					min = temp;
			}
			
			sb.append("#").append(tc).append(" ").append(max).append(" ").append(min).append("\n");
		}
		
		System.out.print(sb);
	}

	private static int count(int n) {
		int cal = 0;
		while (n > 0) {
			cal += (n%10);
			n /= 10;
		}
		return cal;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5603_건초더미 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			int[] arr = new int[N];
			int sum = 0;
			int origin = 0;
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = stoi(br.readLine());
				sum += arr[i];
			}
			
			origin = sum/N;
			
			for (int i = 0; i < N; i++) {
				if(arr[i] > origin)
					answer += (arr[i]-origin);
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

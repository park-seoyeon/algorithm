package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3503_초보자를위한점프대배치하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			int[] arr = new int[N];
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = stoi(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			max = Math.max(max, arr[1]-arr[0]);
			max = Math.max(max, arr[N-1] - arr[N-2]);
			
			for (int i = 0; i < N-2; i++) {
				int n = Math.abs(arr[i] - arr[i+2]);
				max = Math.max(max, n);
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

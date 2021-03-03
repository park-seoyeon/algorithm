package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6190_정곤이의단조증가하는수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			int[] arr = new int[N];
			int max = -1;
			int multi = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = stoi(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					multi = arr[i] * arr[j];
					if (isMonoIncrease(multi) && multi > max)
						max = multi;
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}

	private static boolean isMonoIncrease(int multi) {
		int n;
		int cur = 9;
		
		for (int i = multi; i > 0; i/=10) {
			n  = i % 10;
			if(n > cur) 
				return false;
			if(n < cur) cur = n;
		}
		return true;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

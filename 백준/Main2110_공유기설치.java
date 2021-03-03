package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int min = 1;
		int max = arr[N-1] - arr[0];
		int d = 0;
		int answer = 0;
		
		while (min <= max) {
			int mid = (min + max) / 2;
			int start = arr[0];
			int cnt = 1;
			
			for (int i = 1; i < N; i++) {
				d = arr[i] - start;
				if (mid <= d) {
					++cnt;
					start = arr[i];
				}
			}
			
			if (cnt >= C) {
				answer = mid;
				min = mid + 1;
			}
			else
				max = mid - 1;
		}
		System.out.println(answer);
	}
	
}

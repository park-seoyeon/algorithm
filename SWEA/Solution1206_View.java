package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int map[] = new int[N];
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i < N-2; i++) {
				int temp = 0;
				temp = Math.max(arr[i-2], temp);
				temp = Math.max(arr[i-1], temp);
				temp = Math.max(arr[i+1], temp);
				temp = Math.max(arr[i+2], temp);
				if (arr[i]-temp > 0) {
					map[i] = arr[i] - temp;
				}
			}
			
			for (int i = 2; i < N-2; i++) {
				answer += map[i];
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
}

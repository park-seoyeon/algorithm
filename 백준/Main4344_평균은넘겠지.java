package day210112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4344_평균은넘겠지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			
			float avg = sum/n;
			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				if (arr[i] > avg) {
					cnt++;
				}
			}
			
			float ans = (float) cnt/n;
			ans *= 100;
			System.out.printf("%.3f", ans);
			System.out.println("%");
		}
	}
	
}

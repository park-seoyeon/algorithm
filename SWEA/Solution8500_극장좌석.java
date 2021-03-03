package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution8500_극장좌석 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			int[] arr = new int[N];
			int answer = N;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = stoi(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			answer += (arr[0]*2);
			for (int i = 1; i < N; i++) {
				answer += (arr[i]-arr[i-1]) + arr[i];
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
}

package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5215_햄버거다이어트 {

	private static int N;
	private static int L;
	private static int[] point;
	private static int[] cal;
	private static boolean[] flag;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			L = stoi(st.nextToken());
			point = new int[N];
			cal = new int[N];
			flag = new boolean [N];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = stoi(st.nextToken());
				cal[i] = stoi(st.nextToken());
			}
			
			for (int i = 1; i <= N; i++) {
				Arrays.fill(flag, false);
				comb(0, 0, i);
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void comb(int start, int cnt, int R) {
		if(cnt == R) {
			int csum = 0;
			int psum = 0;
			for (int i = 0; i < N; i++) {
				if(flag[i]) {
					psum += point[i];
					csum += cal[i];
				}
				if(csum > L)
					return;
			}
			
			answer = Math.max(answer, psum);
			return;
		}
		
		for (int i = start; i < N; i++) {
			flag[i] = true;
			comb(i+1, cnt+1, R);
			flag[i] = false;
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

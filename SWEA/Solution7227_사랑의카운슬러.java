package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7227_사랑의카운슬러 {

	private static int N;
	private static int[][] map;
	private static int R;
	private static boolean[] flag;
	private static long answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = stoi(br.readLine());
			map = new int[N][2];
			R = N/2;
			flag = new boolean[N];
			answer = Long.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			
			comb(0,0);
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void comb(int start, int cnt) {
		if(cnt == R) {
			int xsum1 = 0;
			int ysum1 = 0;
			int xsum2 = 0;
			int ysum2 = 0;
			for (int i = 0; i < N; i++) {
				if (flag[i]) {
					xsum1 += map[i][0];
					ysum1 += map[i][1];
				}
				else {
					xsum2 += map[i][0];
					ysum2 += map[i][1];					
				}
			}
			
			long x = xsum1 - xsum2;
			long y = ysum1 - ysum2;
			
			answer = Math.min(answer, (x*x) + (y*y));
			return;
		}
		
		for (int i = start; i < N; i++) {
			flag[i] = true;
			comb(i+1, cnt+1);
			flag[i] = false;
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

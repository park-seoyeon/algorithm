package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6731_홍익이의오델로게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			int[] garo = new int[N];
			int[] sero = new int[N];
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'B') {
						garo[i]++;
						sero[j]++;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = garo[i] + sero[j];
					if (map[i][j] == 'B') cnt--;
					if (cnt % 2 == 1) answer++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
}

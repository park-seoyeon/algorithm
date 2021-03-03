package week07;

import java.util.Scanner;

public class Solution4301_콩많이심기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean[][] map = new boolean[N][M];
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!map[i][j]) {						
						answer++;
						if(i+2 < N) {						
							map[i+2][j] = true;
						}
						if (j+2 < M) {						
							map[i][j+2] = true;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
}

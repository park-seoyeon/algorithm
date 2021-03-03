package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1249_보급로 {

	private static int N;
	private static int[][] map;
	private static int[][] visit;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new int[N][N];
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(visit[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			answer = bfs();
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int bfs() {
		Queue<int []> qu = new LinkedList<int[]>();
		qu.offer(new int[] {0,0});
		visit[0][0] = 0;
		
		while (!qu.isEmpty()) {
			int r = qu.peek()[0];
			int c = qu.peek()[1];
			qu.poll();
			int dis = visit[r][c];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int ndis = dis + map[nr][nc];
					if (visit[nr][nc] > ndis) {
						visit[nr][nc] = ndis;
						qu.offer(new int[] {nr, nc});
					}
				}
			}
		}
		
		return visit[N-1][N-1];
	}
	
}

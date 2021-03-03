package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2382_미생물격리 {

	private static int N;
	private static int M;
	private static int K;
	private static int[][][] map;
	private static int[] dr = {0, -1, 1, 0, 0};
	private static int[] dc = {0, 0, 0, -1, 1};
	private static Queue<Micro> qu;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			K = stoi(st.nextToken());
			map = new int[N][N][3];
			qu = new LinkedList<Micro>();
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = stoi(st.nextToken());
				int c = stoi(st.nextToken());
				int num = stoi(st.nextToken());
				int dir = stoi(st.nextToken());
				qu.offer(new Micro(r, c, num, dir));
			}
			
			for (int i = 0; i < M; i++) {
				run();
			}
			
			
			sb.append("#").append(tc).append(" ").append(count()).append("\n");
		}
		System.out.print(sb);
	}

	private static int count() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j][2] > 0) {
					sum += map[i][j][2];
				}
			}
		}
		return sum;
	}

	private static void run() {
		startmap();
		
		while(!qu.isEmpty()) {
			Micro mic = qu.poll();
			int r = mic.r;
			int c = mic.c;
			int num = mic.num;
			int dir = mic.dir;
			
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			
			if(nr > 0 && nc > 0 && nr < N-1 && nc < N-1) {
				map[nr][nc][2] += num;
				if (map[nr][nc][0] == 0) {
					map[nr][nc][0] = num;
					map[nr][nc][1] = dir;
				}
				else if (map[nr][nc][0] < num) {
					map[nr][nc][0] = num;
					map[nr][nc][1] = dir;					
				}
			}
			else if (nr == 0 || nc == 0 || nr == N-1 || nc == N-1) {
				map[nr][nc][0] = num/2;
				map[nr][nc][1] = (dir%2 == 0) ? dir - 1 : dir + 1;
				map[nr][nc][2] = num/2;
			}
			
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j][2] > 0) {
					qu.offer(new Micro(i, j, map[i][j][2], map[i][j][1]));
				}
			}
		}
		
	}

	private static void startmap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 3; k++) {
					map[i][j][k] = 0;
				}
			}
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
	static class Micro {
		int r;
		int c;
		int num;
		int dir;
		public Micro(int r, int c, int num, int dir) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.dir = dir;
		}
	}
}

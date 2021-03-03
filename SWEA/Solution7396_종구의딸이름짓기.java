package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7396_종구의딸이름짓기 {

	private static int N;
	private static int M;
	private static char[][] map;
	private static int[] dr = {0,1};
	private static int[] dc = {1,0};
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			String answer = bfs(0,0);
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static String bfs(int r, int c) {
		Queue<Node> qu = new LinkedList<Node>();
		StringBuilder sb = new StringBuilder();
		qu.offer(new Node(r,c,map[r][c]));
		visited[r][c] = true;
		char min = map[r][c];
		sb.append(min);
		
		while (!qu.isEmpty()) {
			int len = qu.size();
			char temp = 'z' + 1;
			for (int i = 0; i < len; i++) {				
				Node n = qu.poll();
				int cr = n.r;
				int cc = n.c;
				char calpha = n.alpha;
				
				if (calpha <= min) {
					int nr = 0;
					int nc = 0;
					for (int k = 0; k < 2; k++) {
						nr = cr + dr[k];
						nc = cc + dc[k];
						
						if (nr < N && nc < M && !visited[nr][nc]) {
							if (temp > map[nr][nc]) {
								temp = map[nr][nc];
							}
							qu.offer(new Node(nr,nc,map[nr][nc]));
							visited[nr][nc] = true;
						}
					}
				}
			}
			min = temp;
			if (!qu.isEmpty()) {				
				sb.append(min);
			}
		}
		
		return sb.toString();
	}

	static class Node {
		int r;
		int c;
		char alpha;
		public Node(int r, int c, char alpha) {
			this.r = r;
			this.c = c;
			this.alpha = alpha;
		}
	}
}

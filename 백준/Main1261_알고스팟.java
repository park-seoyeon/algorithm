package day210112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1261_알고스팟 {

	private static int M;
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	static int dr[] = {1, 0, -1, 0};
	static int dc[] = {0, 1, 0, -1};
	private static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N+1][M+1];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine(); 
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0'; 
			}
		}
		
		bfs();
		System.out.println(dist[N-1][M-1]);
	}
	
	private static void bfs() {
		Deque<Node> deq = new LinkedList<Node>();
		deq.addLast(new Node(0,0));
		visited[0][0] = true;
		
		while (!deq.isEmpty()) {
			Node now = deq.pollLast();
			int cr = now.r;
			int cc = now.c;
			
			for (int k = 0; k < 4; k++) {
				int nr = cr + dr[k];
				int nc = cc + dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;
				
				if (map[nr][nc]==0) {
					dist[nr][nc] = dist[cr][cc];
					deq.addLast(new Node(nr, nc));
				}
				else {
					dist[nr][nc] = dist[cr][cc]+1;
					deq.addFirst(new Node(nr, nc));
				}
				visited[nr][nc] = true;
			}
		}
	}

	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

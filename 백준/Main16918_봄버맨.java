package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16918_봄버맨 {

	private static int R;
	private static int C;
	private static int N;
	private static char[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static Queue<Node> qu = new LinkedList<Node>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		if (N != 1) {
			for (int i = 2; i <= N; i++) {
				if (i % 2 == 0)
					even();
				else
					bfs();
			}
		}
		
		print();
		
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	private static void bfs() {
		while (!qu.isEmpty()) {
			Node node = qu.poll();
			int cr = node.r;
			int cc = node.c;
			
			map[cr][cc] = '.';
			for (int k = 0; k < 4; k++) {
				int nr = cr + dr[k];
				int nc = cc + dc[k];
				if(round(nr, nc)) {
					map[nr][nc] = '.';
				}
			}
		}
	}

	private static void even() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'O')
					qu.offer(new Node(i, j));
				else
					map[i][j] = 'O';
			}
		}
	}

	private static boolean round(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}

	private static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}

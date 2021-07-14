package new_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16948_데스나이트 {

	private static int N;
	private static int r1;
	private static int c1;
	private static int r2;
	private static int c2;
	private static int[][] map;
	private static boolean[][] check;
	private static int[] dr = {-2, -2, 0, 0, 2, 2};
	private static int[] dc = {-1, 1, -2, 2, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = stoi(st.nextToken());
		c1 = stoi(st.nextToken());
		r2 = stoi(st.nextToken());
		c2 = stoi(st.nextToken());
		map = new int[N+1][N+1];
		check = new boolean[N+1][N+1];
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(new Node(r1, c1, 0));
		check[r1][c1] = true;
		
		while (!qu.isEmpty()) {
			Node n = qu.poll();
			
			for (int i = 0; i < 6; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr > N || nc > N || check[nr][nc])
					continue;
				if(nr == r2 && nc == c2) {
					return (n.cnt + 1);
				}
				check[nr][nc] = true;
				qu.add(new Node(nr, nc, n.cnt+1));
			}
		}
		
		return -1;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

class Node {
	int r;
	int c;
	int cnt;

	Node(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

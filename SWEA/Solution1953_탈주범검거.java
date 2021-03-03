import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953_탈주범검거 {

	private static int N;
	private static int M;
	private static int R;
	private static int C;
	private static int L;
	private static int[][] map;
	private static boolean[][] visited;
	private static int answer;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static Queue<Node> qu;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			R = stoi(st.nextToken());
			C = stoi(st.nextToken());
			L = stoi(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			answer = 0;
			qu = new LinkedList<Node>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			
			qu.offer(new Node(R, C, map[R][C], 1));
			visited[R][C] = true;
			answer++;
			bfs();
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void bfs() {
		while (!qu.isEmpty()) {
			Node node = qu.poll();
			int cr = node.r;
			int cc = node.c;
			int dir = node.dir;
			int time = node.time + 1;
			
			if(time > L)
				break;
			
			switch (dir) {
			case 1:
				for (int k = 0; k < 4; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			case 2:
				for (int k = 0; k < 2; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			case 3:
				for (int k = 2; k < 4; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			case 4:
				for (int k = 0; k < 4; k+=3) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			case 5:
				for (int k = 1; k < 4; k+=2) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			case 6:
				for (int k = 1; k < 3; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			case 7:
				for (int k = 0; k < 3; k+=2) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					if(round(nr, nc) 
							&& !visited[nr][nc] 
									&& map[nr][nc] != 0) {
						if(check(k, map[nr][nc])) {
							qu.offer(new Node(nr, nc, map[nr][nc], time));
							visited[nr][nc] = true;
							answer++;
						}
					}
				}
				break;
			}
		}
	}

	private static boolean check(int k, int dir) {
		if (k == 0) {
			if(dir == 1 || dir == 2 || dir == 5 || dir == 6)
				return true;
		}
		else if (k == 1) {
			if(dir == 1 || dir == 2 || dir == 4 || dir == 7)
				return true;
		}
		else if (k == 2) {
			if(dir == 1 || dir == 3 || dir == 4 || dir == 5)
				return true;
		}
		else if (k == 3) {
			if(dir == 1 || dir == 3 || dir == 6 || dir == 7)
				return true;
		}
		return false;
	}

	private static boolean round(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
	static class Node {
		int r;
		int c;
		int dir;
		int time;
		
		public Node(int r, int c, int dir, int time) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.time = time;
		}
	}
}

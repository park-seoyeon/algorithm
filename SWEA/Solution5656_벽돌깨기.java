import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5656_벽돌깨기 {

	private static int N;
	private static int W;
	private static int H;
	private static int[][] map;
	private static int[] poses;
	private static boolean[][] visited;
	private static int answer;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			W = stoi(st.nextToken());
			H = stoi(st.nextToken());
			map = new int[H][W];
			poses = new int[N];
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = stoi(st.nextToken());
				}
			}
			
			perm(0);
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void perm(int pos) {
		if (pos == N) {
			int[][] cmap = copy();
			int brick = 0;
			
			for (int i = 0; i < N; i++) {
				visited = new boolean[H][W];
				crush(cmap, poses[i]);
				compact(cmap);
			}
			
			brick = count(cmap);
			answer = Math.min(brick, answer);
			
			return;
		}
		
		for (int j = 0; j < W; j++) {
			poses[pos] = j;
			perm(pos + 1);
		}
	}

	private static int count(int[][] cmap) {
		int sum = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(cmap[i][j] > 0)
					sum++;
			}
		}
		
		return sum;
	}

	private static void compact(int[][] cmap) {
		Queue<Integer> temp;
		
		for (int j = 0; j < W; j++) {
			temp = new LinkedList<Integer>();
			
			for (int i = H - 1; i >= 0 ; --i) {
				if (cmap[i][j] > 0)
					temp.offer(cmap[i][j]);
			}

			for (int i = H - 1; i >= 0 ; --i) {
				if (!temp.isEmpty())
					cmap[i][j] = temp.poll();
				else
					cmap[i][j] = 0;
			}
			
		}
	}

	private static void crush(int[][] cmap, int pos) {
		Queue<Node> qu = new LinkedList<Node>();
		
		for (int i = 0; i < H; i++) {
			if (cmap[i][pos] > 0) {
				qu.offer(new Node(i, pos, cmap[i][pos]));
				break;
			}
		}
		
		while (!qu.isEmpty()) {
			Node cur = qu.poll();
			int nr, nc;
			
			
			for (int k = 0; k < 4; k++) {
				for (int n = 0; n < cur.num; n++) {
					nr = cur.r + dr[k] * n;
					nc = cur.c + dc[k] * n;
					if (round(nr, nc) 
							&& !visited[nr][nc]) {
						visited[nr][nc] = true;
						qu.offer(new Node(nr,nc,cmap[nr][nc]));
						cmap[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static boolean round(int nr, int nc) {
		if(nr >= 0 && nr < H && nc >= 0 && nc < W)
			return true;
		else
			return false;
	}

	private static int[][] copy() {
		int[][] arr = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
	static class Node {
		int r;
		int c;
		int num;
		
		public Node(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}
	
}

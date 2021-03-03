package week05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14499_주사위굴리기 {

	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static int[] dir;
	private static int r;
	private static int c;
	private static int[] dr = {0, 0, -1, 1};
    private static int[] dc = {1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dir = new int[K];
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			dir[i] = Integer.parseInt(st.nextToken());
		}
		
		rolling();
		
		System.out.print(sb);
	}
	
	private static void rolling() {
		Dice dice = new Dice();
		int nr, nc;
		
		for (int i = 0; i < K; i++) {
			int d = dir[i] - 1;
			nr = r + dr[d];
			nc = c + dc[d];
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if (d == 0) dice.mEast();
				else if (d == 1) dice.mWest();
				else if (d == 2) dice.mNorth();
				else if (d == 3) dice.mSouth();
				
				if (map[nr][nc] == 0) {
					map[nr][nc] = dice.bottom;
				}
				else {
					dice.bottom = map[nr][nc];
					map[nr][nc] = 0;
				}
				
				sb.append(dice.top).append("\n");
				
				r = nr;
				c = nc;
			}
		}
		
	}

	static class Dice {
		int top, bottom, west, east, north, south;

		public Dice() {
			super();
			this.top = 0;
			this.bottom = 0;
			this.west = 0;
			this.east = 0;
			this.north = 0;
			this.south = 0;
		}
		
		public void mEast() {
			int temp = top;
			top = west;
			west = bottom;
			bottom = east;
			east = temp;
		}
		
		public void mWest() {
			int temp = top;
			top = east;
			east = bottom;
			bottom = west;
			west = temp;
		}
		
		public void mNorth() {
			int temp = top;
			top = south;
			south = bottom;
			bottom = north;
			north = temp;
		}
		
		public void mSouth() {
			int temp = top;
			top = north;
			north = bottom;
			bottom = south;
			south = temp;
		}
	}
}

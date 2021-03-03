import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17144_미세먼지안녕 {

	private static int R;
	private static int C;
	private static int T;
	private static int[][] map;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static Cleaner[] cleaner = new Cleaner[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int answer = 0;
		int index = 0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					cleaner[index++] = new Cleaner(i, j);
			}
		}
		
		for (int i = 0; i < T; i++) {
			spread(new int[R][C]);
			clean(new int [R][C]);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] <= 0) continue;
				answer += map[i][j];
			}
		}
		
		System.out.println(answer);
	}
	
	private static void clean(int[][] cmap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cmap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 2; i++) {
			Cleaner cur = cleaner[i];
			int px = cur.r;
			int py = cur.c;
			
			while (py < C-1) {
				cmap[px][py + 1] = map[px][py];
				py++;
			}
			
			if (i == 0) {
				while (px > 0) {
					cmap[px-1][py] = map[px][py];
					px--;
				}
			} else {
				while (px < R-1) {
					cmap[px+1][py] = map[px][py];
					px++;
				}
			}

			while (py > 0) {
				cmap[px][py - 1] = map[px][py];
				py--;
			}
			
			if (i == 0) {
				while (px < cur.r-1) {
					cmap[px+1][py] = map[px][py];
					px++;
				}
			} else {
				while (px > cur.r+1) {
					cmap[px-1][py] = map[px][py];
					px--;
				}
			}			
			cmap[cur.r][cur.c] = -1;
			cmap[cur.r][cur.c+1] = 0;
		}
		copy(cmap);
	}
	private static void spread(int[][] cmap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cmap[i][j] += map[i][j];
				if (map[i][j] < 5) continue;
				int sCount = map[i][j]/5;
				for (int k = 0; k < 4; k++) {
					int px = i + dx[k];
					int py = j + dy[k];
					
					if (px >= 0 && px < R && py >=0 && py < C && map[px][py] != -1) {
						cmap[i][j] -= sCount;
						cmap[px][py] += sCount;
					}
				}
			}
		}
		copy(cmap);
	}
	
	private static void copy(int[][] cmap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = cmap[i][j];
			}
		}
	}
	public static class Cleaner {
		int r, c;

		public Cleaner(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}

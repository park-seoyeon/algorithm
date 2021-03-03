

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1868_파핑파핑지뢰찾기 {

	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != '.') continue;
					
					int mine = 0;
					
					for (int k = 0; k < 8; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if (range(nr, nc)
								&& map[nr][nc] == '*') 
							mine++;
					}
					
					if(mine == 0) {
						bfs(i, j);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '.') cnt++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
			cnt = 0;
		}
		
		System.out.print(sb);
	}

	private static void bfs(int i, int j) {
		cnt++;
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.offer(new int[] {i, j});
		
		while (!qu.isEmpty()) {
			int cr = qu.peek()[0];
			int cc = qu.peek()[1];
			qu.poll();
			
			int mine = 0;
			
			for (int k = 0; k < 8; k++) {
				int nr = cr + dr[k];
				int nc = cc + dc[k];
				
				if (range(nr, nc)
						&& map[nr][nc] == '*') 
					mine++; 
			}
			
			map[cr][cc] = 'x';
			
			if (mine == 0) {
				for (int k = 0; k < 8; k++) {
					int nr = cr + dr[k];
					int nc = cc + dc[k];
					
					if (!range(nr, nc) || map[nr][nc] != '.' || visited[nr][nc]) 
						continue;
					
					visited[nr][nc] = true;
					
					qu.add(new int[] {nr, nc});
				}
			}
		}
		
	}

	private static boolean range(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true; 
		return false;
	}
	
}

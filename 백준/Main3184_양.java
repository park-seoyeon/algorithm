package week05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3184_양 {

	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][] visited;
	private static int dr[] = {0, -1, 0, 1};
	private static int dc[] = {-1, 0, 1, 0};
	private static int sheep;
	private static int wolf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		sheep = 0;
		wolf = 0;
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'o')
					sheep++;
				else if(map[i][j] == 'v')
					wolf++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'o')
					bfs(i, j);
			}
		}
		
		System.out.print(sheep + " " + wolf);
	}

	private static void bfs(int i, int j) {
		int s = 1;
		int w = 0;
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!qu.isEmpty()) {
			int cr = qu.peek()[0];
			int cc = qu.peek()[1];
			qu.poll();
			for (int k = 0; k < 4; k++) {
				int nr = cr+dr[k];
				int nc = cc+dc[k];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] != '#'
							&& !visited[nr][nc]) {
						if (map[nr][nc] == 'o') {
							s += 1;
							qu.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
						else if (map[nr][nc] == 'v') {
							w += 1;
							qu.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
						else {
							qu.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
						}
					}
				}
			}
		}
		
		if (s > w) {
			wolf -= w;
		}
		else {
			sheep -= s;
		}
	}
	
}

package algo_d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1226_미로1 {

	static int map[][], answer;
	static boolean visited[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("input_1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
			int test = Integer.parseInt(br.readLine());
			map = new int[16][16];
			visited = new boolean[16][16];
			answer = 0;
			
			for (int i = 0; i < 16; i++) {
				String s = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			for (int i = 0; i < 16; i++) {
				for (int j = 0; j < 16; j++) {
					if (map[i][j] == 2) {
						bfs(i,j);
					}
				}
			}
			System.out.println("#" + test + " " + answer);
		}
	}
	
	private static void bfs(int i, int j) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.offer(new int[] {i, j});
		visited[i][j] = true;
		
		while(!qu.isEmpty()) {
			int cx = qu.peek()[0];
			int cy = qu.peek()[1];
			qu.poll();
			for (int k = 0; k < 4; k++) {
				if (cx+dx[k] >= 0 && cx+dx[k] < 16 && cy+dy[k] >= 0 && cy+dy[k] < 16) {
					if (map[cx+dx[k]][cy+dy[k]] == 0
							&&!visited[cx+dx[k]][cy+dy[k]]) {
						qu.offer(new int[] {cx+dx[k],cy+dy[k]} );
						visited[cx+dx[k]][cy+dy[k]] = true;
					}
					else if (map[cx+dx[k]][cy+dy[k]] == 3) {
						answer = 1;
						qu.clear();
					}
				}
			}
		}
	}
	
}

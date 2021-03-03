package week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1220_Magnetic {

	private static int[][] map;
	private static int cnt;
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] 
							&& map[i][j] == 1) {
						visited[i][j] = true;
						find(i,j);
					}
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}

	private static void find(int r, int c) {
		for (int i = r; i < 100; i++) {
			if (map[i][c] == 1) {
				visited[i][c] = true;
			}
			if(!visited[i][c] 
					&& map[i][c] == 2) {
				visited[i][c]  = true;
				cnt += 1;
				return;
			}
		}
	}
	
}

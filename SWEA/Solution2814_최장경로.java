package week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2814_최장경로 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[] visited;
	private static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N+1][N+1];
			visited = new boolean[N+1];
			answer = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
				map[c][r] = 1;
			}
			
			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

	private static void dfs(int idx, int cnt) {
		if (answer < cnt) answer = cnt;
		
		for (int i = 1; i <= N; i++) {
			if (map[idx][i] == 1
					&& visited[i] == false) {
				visited[i] = true;
				dfs(i, cnt+1);
				visited[i] = false;
			}
		}
	}
	
}

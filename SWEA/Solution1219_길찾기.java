package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1219_길찾기 {

	private static int answer;
	private static int[][] map;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int TC = Integer.parseInt(st.nextToken());
			int way = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new int[100][100];
			visited = new boolean[100];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < way; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			
			dfs(0);
			sb.append("#").append(TC).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}

	private static void dfs(int x) {
		if (answer == 1)
			return;
		if (x == 99) {
			answer = 1;
			return;
		}
		
		visited[x] = true;
		for (int i = 0; i < 100; i++) {
			if (!visited[i]
					&& map[x][i] == 1) {
				dfs(i);
			}
		}
		visited[x] = false;
	}
	
}

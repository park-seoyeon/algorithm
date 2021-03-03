import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987_알파벳 {

	static int R, C, answer;
	static char map[][];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 1 <= R, C <= 20
		C = Integer.parseInt(st.nextToken()); // 1 <= R, C <= 20
		map = new char[R][C];
		visited = new boolean['Z' + 1];
		answer = 1;
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited[map[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(answer);
	}
	
	private static void dfs(int i, int j, int sum) {
		answer = Math.max(sum, answer);
		if (answer == 26)
			return;
		
		if ((i-1) >= 0 && !visited[map[i-1][j]]) {
			visited[map[i-1][j]] = true;
			dfs(i-1, j, sum+1);
			visited[map[i-1][j]] = false;
		}
		if ((i+1) < R && !visited[map[i+1][j]]) {
			visited[map[i+1][j]] = true;
			dfs(i+1, j, sum+1);
			visited[map[i+1][j]] = false;
		}
		if ((j-1)>=0 && !visited[map[i][j-1]]) {
			visited[map[i][j-1]] = true;
			dfs(i, j-1, sum+1);
			visited[map[i][j-1]] = false;
		}
		if ((j+1) < C && !visited[map[i][j+1]]) {
			visited[map[i][j+1]] = true;
			dfs(i, j+1, sum+1);
			visited[map[i][j+1]] = false;
		}
	}
}

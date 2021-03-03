import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2115_벌꿀채취 {

	private static int N;
	private static int M;
	private static int C;
	private static int[][] hive;
	private static boolean[][] visited;
	private static boolean[] flag;
	private static int[][] worker;
	private static int answer;
	private static int[] honey;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			C = stoi(st.nextToken());
			hive = new int[N][N];
			visited = new boolean[N][N];
			flag = new boolean[M];
			worker =new int[2][M];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					hive[i][j] = stoi(st.nextToken());
				}
			}
			
			select(0, -1);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.print(sb);
	}

	private static void select(int index, int pos) {
		if (index == 2) {
			int total = 0;
			honey = new int[2];
			
			for (int i = 0; i < 2; i++) {
				find(i, 0, 0);
				total += honey[i];
			}
			
			answer = Math.max(total, answer);
		
			return;
		}
		
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (i * 10 + j <= pos)
					continue;
				if (j + M - 1 >= N || visited[i][j])
					continue;
				
				for (int k = 0; k < M; k++) {
					visited[i][j + k] = true;
					worker[index][k] = hive[i][j + k];
				}
				
				select(index + 1, i * 10 + j);
				
				for (int k = 0; k < M; k++) {
					visited[i][j + k] = false;
				}
			}
		}
	}

	private static void find(int index, int sum, int money) {
		honey[index] = Math.max(money, honey[index]);
		
		for (int k = 0; k < M; k++) {
			if (flag[k])
				continue;
			
			if (sum + worker[index][k] <= C) {
				flag[k] = true;
				find(index, sum + worker[index][k], money + (worker[index][k] * worker[index][k]));
				flag[k] = false;
				
			}
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

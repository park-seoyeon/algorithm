package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684_사다리조작 {

	private static int N;
	private static int M;
	private static int H;
	private static int[][] map;
	private static boolean flag;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		H = stoi(st.nextToken());
		map = new int[H+1][N+1];
		flag = false;
		answer = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		
		if (check()) {
			flag = true;
		}
		else {
			for (int i = 1; i <= 3; i++) {
				if (flag)
					break;
				answer = i;
				dfs(1, 0);
			}
		}
		
		if (!flag)
			answer = -1;
		System.out.println(answer);
	}

	private static void dfs(int x, int cnt) {
		if (answer == cnt) {
			if (check())
				flag = true;
			return;
		}
		
		if (flag)
			return;
		
		for (int i = x; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0 && map[i][j+1] == 0) {
					map[i][j] = 1;
					map[i][j+1] = -1;
					dfs(i, cnt+1);
					map[i][j] = map[i][j+1] = 0;
				}
			}
		}
		
	}

	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = 1;
			int y = i;
			for (int j = 0; j < H; j++) {
				if (map[x][y] == 1)
					y++;
				else if(map[x][y] == -1)
					y--;
				x++;
			}
			if (y != i) 
				return false;
		}
		return true;
	}

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
	
}

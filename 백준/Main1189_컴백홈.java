package new_week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1189_컴백홈 {

	static boolean[][] check = new boolean[6][6];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	private static int R;
	private static int C;
	private static int K;
	static char[][] arr = new char[6][6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		K = stoi(st.nextToken());

		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		check[R - 1][0] = true;
		arr[0][C - 1] = 'H';
		
		System.out.println(dfs(R - 1, 0, 1));
	}

	private static int dfs(int r, int c, int cnt) {
		if (cnt == K) {
			return arr[r][c] == 'H' ? 1 : 0;
		}

		int re = 0;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C || arr[nr][nc] == 'T' || check[nr][nc])
				continue;
			check[nr][nc] = true;
			re += dfs(nr, nc, cnt + 1);
			check[nr][nc] = false;
		}
		return re;
	}

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
}

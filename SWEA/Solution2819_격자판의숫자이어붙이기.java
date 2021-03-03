package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution2819_격자판의숫자이어붙이기 {

	private static int[][] map;
	private static int[] dr = { -1, 0, 1, 0 };
	private static int[] dc = { 0, -1, 0, 1 };
	private static HashSet<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];
			set = new HashSet<>();

			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0, "" + map[i][j]);
				}
			}
			System.out.println("#" + tc + " " + set.size());
		}
	}

	private static void dfs(int i, int j, int len, String string) {
		if (len == 6) {
			set.add(string);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int r = i + dr[k];
			int c = j + dc[k];
			if (r >= 0 && r < 4 && c >= 0 && c < 4) {
				dfs(r, c, len+1, string + map[r][c]);
			}
		}
	}

}

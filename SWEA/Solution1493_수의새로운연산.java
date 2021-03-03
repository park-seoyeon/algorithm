package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1493_수의새로운연산 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int map[][] = new int[1001][1001];
		int cnt = 1;
		for (int i = 1; cnt <= 100000; i++) {
			for (int j = 1, k = i; j <= i; j++, k--) {
				map[k][j] = cnt++;
			}
		}
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int px = 0, py = 0, qx = 0, qy = 0;
			
ex:			for (int i = 1; i < 1001; i++) {
				for (int j = 1; j < map.length; j++) {
					if (map[i][j] == p) {
						px = i;
						py = j;
					}
					if (map[i][j] == q) {
						qx = i;
						qy = j;
					}
					if (px != 0 & qx != 0)
						break ex;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(map[px+qx][py+qy]).append("\n");
		}
		System.out.print(sb);
	}
	
}

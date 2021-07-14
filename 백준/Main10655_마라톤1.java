package new_week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10655_마라톤1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = stoi(br.readLine());
		int[][] map = new int[n][2];
		int[] dist = new int[n-1];
		int sum = 0;
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = stoi(st.nextToken());
			map[i][1] = stoi(st.nextToken());
		}
		
		for (int i = 0; i < n-1; i++) {
			dist[i] = cal(map[i], map[i+1]);
			sum += dist[i];
		}
		
		for (int i = 0; i < n-2; i++) {
			int s = cal(map[i], map[i+2]);
			max = Math.max(max, dist[i]+dist[i+1]-s);
		}
		
		System.out.println(sum-max);
	}

	private static int cal(int[] from, int[] to) {
		return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
}

package week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1209_Sum {

	private static int[][] map;
	private static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];
			max = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			calc();
			
			sb.append("#").append(T).append(" ").append(max).append("\n");
		}
		System.out.print(sb);
	}

	private static void calc() {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += map[i][j];
			}
			max = Math.max(sum, max);
			sum = 0;
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				sum += map[j][i];
			}
			max = Math.max(sum, max);
			sum = 0;
		}
		
		for (int i = 0; i < 100; i++) {
			sum += map[i][i];
		}
		max = Math.max(sum, max);
		sum = 0;
		
		int j = 0;
		for (int i = 99; i >= 0; i--) {
			sum += map[i][j++];
		}
		
		max = Math.max(sum, max);
		sum = 0;
	}
	
}

package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16967_배열복원하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = stoi(st.nextToken());
		int W = stoi(st.nextToken());
		int X = stoi(st.nextToken());
		int Y = stoi(st.nextToken());
		int R = H+X;
		int C = W+Y;
		int[][] arr = new int[H+X][W+Y];
		int[][] ans = new int[H][W];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				ans[i][j] = arr[i][j];
			}
		}
		
		int xidx = 0;
		int yidx = 0;
		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				ans[i][j] -= ans[xidx][yidx];
				yidx++;
			}
			xidx++;
			yidx = 0;
		}
		
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
	
}

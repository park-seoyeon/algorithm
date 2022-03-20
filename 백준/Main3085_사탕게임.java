package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3085_사탕게임 {

	private static int N;
	private static char map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N) {
					if(map[i][j] != map[i][j + 1]) {						
						char temp = map[i][j];
						map[i][j] = map[i][j + 1];
						map[i][j + 1] = temp;
						answer = Math.max(answer, count());
						temp = map[i][j];
						map[i][j] = map[i][j + 1];
						map[i][j + 1] = temp;
					}
				}
				if (i + 1 < N) {
					if(map[i][j] != map[i + 1][j]) {						
						char temp = map[i][j];
						map[i][j] = map[i + 1][j];
						map[i + 1][j] = temp;
						answer = Math.max(answer, count());
						temp = map[i][j];
						map[i][j] = map[i + 1][j];
						map[i + 1][j] = temp;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

	private static int count() {
		int result = 1;
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if(map[i][j] == map[i][j - 1]) {
					cnt += 1;
				}
				else {
					cnt = 1;
				}
				
				result = Math.max(result, cnt);
			}
			
			cnt = 1;
			
			for (int j = 1; j < N; j++) {
				if(map[j][i] == map[j - 1][i]) {
					cnt += 1;
				}
				else {
					cnt = 1;
				}
				result = Math.max(result, cnt);
			}
		}
		return result;
	}

}

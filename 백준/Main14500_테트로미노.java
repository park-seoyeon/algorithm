package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500_테트로미노 {
	
	static int answer, map[][], N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tetris(i, j);
			}
		}
		System.out.println(answer);
	}
	
	private static void tetris(int i, int j) {
		int total = 0;
		// case1
		if (i + 3 < N) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+2][j];
			total += map[i+3][j];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case2
		if (j + 3 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i][j+2];
			total += map[i][j+3];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case3
		if (i + 1 < N && j + 1 < M) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i][j+1];
			total += map[i+1][j+1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case4
		if (i + 2 < N && j + 1 < M) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+2][j];
			total += map[i+2][j+1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case5
		if (i + 1 < N && j + 2 < M) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i][j+1];
			total += map[i][j+2];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case6
		if (i + 2 < N && j + 1 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i+1][j+1];
			total += map[i+2][j+1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case7
		if (i - 1 >= 0 && j + 2 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i][j+2];
			total += map[i-1][j+2];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case8
		if (i + 2 < N && j - 1 >= 0) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+2][j];
			total += map[i+2][j-1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case9
		if (i + 1 < N && j +2 < M) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+1][j+1];
			total += map[i+1][j+2];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case10
		if (i + 2 < N && j + 1 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i+1][j];
			total += map[i+2][j];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case11
		if (i + 1 < N && j + 2 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i][j+2];
			total += map[i+1][j+2];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case12
		if (i + 2 < N && j + 1 < M) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+1][j+1];
			total += map[i+2][j+1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case13
		if (i + 1 < N && j + 1 < M && j - 1 >= 0) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i+1][j];
			total += map[i+1][j-1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case14
		if (i + 2 < N && j - 1 >= 0) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+1][j-1];
			total += map[i+2][j-1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case15
		if (i + 1 < N && j + 2 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i+1][j+1];
			total += map[i+1][j+2];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case16
		if (i + 1 < N && j + 1 < M && j - 1 >= 0) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+1][j-1];
			total += map[i+1][j+1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case17
		if (i + 2 < N && j + 1 < M) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+1][j+1];
			total += map[i+2][j];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case18
		if (i + 1 < N && j + 2 < M) {
			total += map[i][j];
			total += map[i][j+1];
			total += map[i][j+2];
			total += map[i+1][j+1];
			if (answer < total) {
				answer = total;
			}
		}
		total = 0;
		
		// case19
		if (i + 2 < N && j - 1 >= 0) {
			total += map[i][j];
			total += map[i+1][j];
			total += map[i+2][j];
			total += map[i+1][j-1];
			if (answer < total) {
				answer = total;
			}
		}
	}

}

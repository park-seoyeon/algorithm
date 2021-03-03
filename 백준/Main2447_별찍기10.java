package week08;

import java.util.Scanner;

public class Main2447_별찍기10 {

	private static int N;
	private static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N==3) {
			System.out.println("***");
			System.out.println("* *");
			System.out.println("***");
			return;
		}
		map = new char[N][N];
		int m = (N/3);
		
		for (int i = 0; i < N; i+=m) {
			for (int j = 0; j < N; j+=m) {
				if (i == m  && j == m) {
					for (int k = i; k < i+m; k++) {
						for (int z = j; z < j+m; z++) {
							map[k][z] = ' ';
						}
					}
				}
				else {
					star(i,j,m);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(new String(map[i]));
		}
	}

	private static void star(int i, int j, int M) {
		if(M == 3) {
			map[i][j] = '*';
			map[i+1][j] = '*';
			map[i+2][j] = '*';
			map[i][j+1] = '*';
			map[i][j+2] = '*';
			map[i+1][j+1] = ' ';
			map[i+1][j+2] = '*';
			map[i+2][j+1] = '*';
			map[i+2][j+2] = '*';
			return;
		}
		
		int m = (M/3);
		
		for (int k = i; k < i+M; k+=m) {
			for (int z = j; z < j+M; z+=m) {
				if (k == (i+m) && z == (j+m)) {
					for (int l = k; l < k+m; l++) {
						for (int l2 = z; l2 < z+m; l2++) {
							map[l][l2] = ' ';
						}
					}
				}
				else {
					star(k, z, m);
				}
			}
		}
	}

}

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1992_쿼드트리 {

	static int N, map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		exp(0,0,N);
		System.out.println(sb);
	}
	
	private static void exp(int x, int y, int n) {
		if (check(x,y,n)) {
			sb.append(map[x][y]);
		}else {
			sb.append("(");
			int divide = n/2;
			exp(x,y,divide);
			exp(x,y+divide,divide);
			exp(x+divide,y,divide);
			exp(x+divide,y+divide,divide);
			sb.append(")");
		}
	}

	private static boolean check(int x, int y, int n) {
		int tmp = map[x][y];
		for (int i = x; i < x+n; i++) {
			for (int j = y; j < y+n; j++) {
				if (tmp != map[i][j]) return false;
			}
		}
		return true;
	}
	
	
}

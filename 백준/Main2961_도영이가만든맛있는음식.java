package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2961_도영이가만든맛있는음식 {
	
	static int N, input[][], numbers[], answer, diff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {			
			combination(0, i, 0);
		}
		System.out.println(answer);
	}
	
	private static void combination(int cnt, int select, int start) {
		if (cnt == select) {
			int S = 1;
			int B = 0;
			for (int i = 0; i < select; i++) {
				S *= input[numbers[i]][0];
				B += input[numbers[i]][1];
			}
			diff = Math.abs(S-B);
			if(answer > diff) answer = diff;
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, select, i+1);
		}
	}

}

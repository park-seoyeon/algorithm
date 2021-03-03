package com.ssafy.algo;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution8935_스팟마트 {
	static int  N, M, snacks[], numbers[], answer;
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			answer = -1;
			snacks = new int[N];
			numbers = new int[2];
			for (int i = 0; i < N; i++) {
				snacks[i] = sc.nextInt();
			}
			snack(0,0,0);
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
	
	private static void snack(int sum, int cnt, int start) {
		if (cnt == 2) {
			if (sum <= M) {
				if (answer < sum) {
					answer = sum;
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = snacks[i];
			snack(sum+snacks[i], cnt+1, i+1);
		}
	}
	
}

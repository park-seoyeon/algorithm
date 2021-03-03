package com.java.algo;

import java.util.Scanner;

public class Jungol1863_종교 {
	
	static int N;
	static int[] parents;
	static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) { // 암기
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]); // path compression 최적화
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int answer = 0;
		parents = new int[N+1];
		make();
		
		for (int i = 0; i < M; i++) {
			int st1 = sc.nextInt();
			int st2 = sc.nextInt();
			union(st1, st2);
		}
		
		for (int i = 1; i <= N; i++) {
			if (i == parents[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
}

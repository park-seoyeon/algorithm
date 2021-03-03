package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2493_탑 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack = new Stack<int[]>(); // 스택생성
		Queue<Integer> qu = new LinkedList<Integer>();
		
		int N = Integer.parseInt(in.readLine()); //탑의 개수
		StringTokenizer st = new StringTokenizer(in.readLine()); // 탑의 높이들을 받아옴
		
		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken()); // 탑의 높이
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= top) {
					qu.offer(stack.peek()[0]);
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				qu.offer(0);
			}
			stack.push(new int[] {i, top});
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(qu.poll() + " ");
		}
	}

}

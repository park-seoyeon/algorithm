package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1068_트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		int[] tree = new int[N];
		boolean[] sig = new boolean[N];
		int answer = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			tree[i] = stoi(st.nextToken());
		}
		
		int node = stoi(br.readLine());
		
		if (tree[node] == -1) {
			System.out.println(0);
			return;
		}
		
		qu.offer(node);
		tree[node] = -2;
		
		while (!qu.isEmpty()) {
			int n = qu.poll();
			for (int i = 0; i < N; i++) {
				if (tree[i] == n) {
					qu.offer(i);
					tree[i] = -2;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (tree[i] == -1 || tree[i] == -2) {
				sig[i] = true;
			}
			if (tree[i] >= 0) {
				sig[tree[i]] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (!sig[i]) {
				answer++;
			}
		}
		
		if (answer == 0) {
			answer = 1;
		}
		
		System.out.println(answer);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

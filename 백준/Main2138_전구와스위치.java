package week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2138_전구와스위치 {

	private static int N;
	private static boolean[] cur1;
	private static boolean[] cur2;
	private static boolean[] goal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cur1 = new boolean[N];
		cur2 = new boolean[N];
		goal = new boolean[N];
		int cnt1 = 1;
		int cnt2 = 0;
		boolean flag1 = false;
		boolean flag2 = false;
		int answer = Integer.MAX_VALUE;
		String c = br.readLine();
		String s = br.readLine();
		
		if (c.equals(s)) {
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(c.charAt(i) == '1') {				
				cur1[i] = true;
				cur2[i] = true;
			}
			if(s.charAt(i) == '1')
				goal[i] = true;
		}
		
		on(cur1, 0);
		
		for (int i = 1; i < N; i++) {
			if (cur1[i-1] != goal[i-1]) {
				on(cur1, i);
				cnt1++;
			}
			if (cur2[i-1] != goal[i-1]) {
				cnt2++;
				on(cur2, i);
			}
		}
		
		if(Arrays.equals(cur1, goal))
			flag1 = true;
		if(Arrays.equals(cur2, goal))
			flag2 = true;
		
		if(flag1) answer = cnt1;
		if(flag2) answer = Math.min(answer, cnt2);
		
		System.out.println(answer == Integer.MAX_VALUE? -1 : answer);
	}

	private static void on(boolean[] cur, int idx) {
		for (int i = idx-1; i <= idx+1; i++) {
			if (i >= 0 && i < N) {
				cur[i] = !cur[i];
			}
		}
	}
	
}

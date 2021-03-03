package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main20055_컨베이어벨트위의로봇 {

	private static int N;
	private static int K;
	private static int[] conv;
	private static boolean[] robot;
	private static int len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		len = 2*N;
		conv = new int[len];
		robot = new boolean[N];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; i++) {
			conv[i] = stoi(st.nextToken());
		}
		
		while (!check()) {
			rotation();
			move();
			if (!robot[0])
				putOn();
			answer++;
		}
		
		System.out.println(answer);
	}


	private static void putOn() {
		if(conv[0] > 0) {			
			robot[0] = true;
			conv[0]--;
		}
	}


	private static void move() {
		// 0 1 2 3 4
		// 
		for (int i = N-1; i > 0; i--) {
			if (robot[i-1]) {
				if (!robot[i]) {
					if (conv[i] > 0) {						
						robot[i] = true;
						robot[i-1] = false;
						conv[i]--;
					}
				}
			}
		}
		
		robot[N-1] = false;
	}


	private static boolean check() {
		int zero = 0;
		for (int i = 0; i < len; i++) {
			if (conv[i] == 0)
				zero++;
		}
		if (zero >= K)
			return true;
		return false;
	}

	private static void rotation() {
		// 0 1 2 3 4 5
		// 5 0 1 2 3 4
		int temp = conv[len-1];
		for (int i = len-1; i > 0; i--) {
			conv[i] = conv[i-1];
		}
		conv[0] = temp;
		
		for (int j = N-2; j > 0; j--) {			
			robot[j] = robot[j-1];
		}
		robot[0] = false;
		robot[N-1] = false;
	}

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
	
}

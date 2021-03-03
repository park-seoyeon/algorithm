package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4111_무선단속카메라 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			int K = stoi(br.readLine());
			int[] cam = new int[N];
			int[] diff = new int[N-1];
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cam[i] = stoi(st.nextToken());
			}
			
			Arrays.sort(cam);
			
			for (int i = 0; i < N-1; i++) {
				diff[i] = cam[i+1] - cam[i];
			}
			
			Arrays.sort(diff);
			
			if(K >= N) {
				answer = 0;
			}
			else {
				answer = cam[N-1] - cam[0];
				int temp = N-2;
				for (int i = 1; i < K; i++) {
					answer -= diff[temp];
					temp--;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

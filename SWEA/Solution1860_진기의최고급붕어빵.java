package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1860_진기의최고급붕어빵 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int num = 0;
			int p[] = new int[N];
			boolean flag = true;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				p[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(p);
			
			for (int i = 0; i < N; i++) {
				num = K * (p[i]/M);
				if(num < (i+1))
					flag = false;
			}
			
			System.out.println("#" + tc + " " + (flag ? "Possible" : "Impossible"));
		}
	}
	
}

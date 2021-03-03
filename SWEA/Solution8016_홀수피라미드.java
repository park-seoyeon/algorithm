package week07;

import java.util.Scanner;

public class Solution8016_홀수피라미드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();
			long Lindex = (N-1)*(N-1);
			long Lanswer = (2*Lindex) + 1;
			long Rindex = N*N;
			long Ranswer = (2*Rindex) - 1;
			
			System.out.println("#" + tc + " " + Lanswer + " " + Ranswer);
		}
	}
	
}

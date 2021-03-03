package day210120;

import java.util.Scanner;

public class Main10818_최대최소 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(min > num)
				min = num;
			if(max < num)
				max = num;
		}
		
		System.out.println(min + " " + max);
	}
	
}

package level04;

import java.util.Scanner;

public class Main1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		float[] score = new float[N];
		float max = 0;
		float sum = 0;
		
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			if (max < score[i]) {
				max = score[i];
			}
		}
		
		for (int i = 0; i < N; i++) {
			score[i] = score[i]/max*100;
			sum += score[i];
		}
		
		System.out.println(sum/N);
	}
	
}

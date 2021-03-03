package level03;

import java.util.Scanner;

public class Main10952_AplusB5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if (A == 0 && B == 0) {
				flag = false;
				break;
			}
			System.out.println(A+B);
		}
	}
	
}

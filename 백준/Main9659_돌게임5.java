package week14;

import java.util.Scanner;

public class Main9659_돌게임5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		if (n % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}
	
}

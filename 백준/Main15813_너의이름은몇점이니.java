package level05;

import java.util.Scanner;

public class Main15813_너의이름은몇점이니 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		char[] name = sc.next().toCharArray();
		int point = 0;
		
		for (int i = 0; i < len; i++) {
			point += name[i] - 'A' + 1;
		}
		
		System.out.println(point);
	}
	
}

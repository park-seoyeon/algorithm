package new_week04;

import java.util.HashMap;
import java.util.Scanner;

public class Main11478_서로다른부분문자열의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int len = S.length();
		
		for (int i = 0; i < len; i++) {
			String temp = "";
			for (int j = i+1; j <= len; j++) {
				temp = S.substring(i, j);
				if(map.containsKey(S.substring(i, j)))
					continue;
				else {
					map.put(temp, 1);
				}
			}
		}
		System.out.println(map.size());
	}

}

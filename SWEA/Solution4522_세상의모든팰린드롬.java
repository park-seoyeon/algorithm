package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4522_세상의모든팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			char[] arr = br.readLine().toCharArray();
			String s = "Exist";
			
			int len = arr.length;
			int idx = len-1;
			
			for (int i = 0; i < len; i++) {
				if(arr[i] != '?') {
					if(arr[idx-i] == arr[i] || arr[idx-i] == '?')
						continue;
					else {						
						s = "Not exist";
						break;
					}
				}
				else
					continue;
			}
			
			System.out.println("#" + tc + " " + s);
		}
	}
	
}

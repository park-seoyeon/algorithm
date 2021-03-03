package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5550_나는개구리로소이다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			char[] flog = {'c', 'r', 'o', 'a', 'k'};
			String s = br.readLine();
			int[] arr = new int[5];
			int len = s.length();
			int answer = 0;
			boolean flag = true;
			
			for (int i = 0; i < len; i++) {
				answer = Math.max(answer, arr[0]);
				for (int j = 0; j < 5; j++) {
					if (s.charAt(i) == flog[j]) {
						arr[j]++;
						if (j > 0 && arr[j] > arr[j-1]) {
							flag = false;
							break;
						}
						if (j == 4) {
							for (int k = 0; k < 5; k++) {
								arr[k]--;
							}
						}
					}
				}
			}
						
			for (int i = 0; i < 5; i++) {
				if(arr[i] != 0) {
					flag = false;
					break;
				}
			}
			
			if(!flag)
				answer = -1;
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
}

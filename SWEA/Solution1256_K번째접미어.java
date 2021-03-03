package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution1256_K번째접미어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int len = s.length();
			ArrayList<String> list = new ArrayList<String>();
			
			for (int i = 0; i < len; i++) {
				list.add(s.substring(i, len));
			}
			
			Collections.sort(list);
			
			if (list.size() >= K) {
				System.out.println("#" + tc + " " + list.get(K-1));
			}
			else {
				System.out.println("#" + tc + " none");				
			}
		}
	}
	
}

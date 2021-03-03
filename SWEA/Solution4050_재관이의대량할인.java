package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution4050_재관이의대량할인 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = stoi(br.readLine());
			int answer = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				list.add(stoi(st.nextToken()));
			}
			
			Collections.sort(list);
			Collections.reverse(list);
			
			for (int i = 0; i < N; i++) {
				if(i%3 == 2)
					continue;
				answer += list.get(i);
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
}

package day1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5658_보물상자비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int K = stoi(st.nextToken());
			int side = N/4;
			Set<Integer> set = new HashSet<Integer>();
			String str = br.readLine();
			String newStr = str.concat(str.substring(0, (side-1)));
			int answer = 0;
			
			for (int i = 0; i < N; i++) {
				String temp = newStr.substring(i, side+i);
				set.add(stoo(temp));
			}
			
			Integer[] arr = new Integer[set.size()];
			set.toArray(arr);
			
			Arrays.sort(arr, Collections.reverseOrder());
			
			answer = arr[K-1];
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int stoo(String temp) {
		return Integer.parseInt(temp, 16);
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

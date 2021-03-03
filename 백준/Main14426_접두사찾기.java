package week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14426_접두사찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String>[] list = new ArrayList[26];
		int answer = 0;
		
		for (int i = 0; i < 26; i++) {
			list[i] = new ArrayList<String>();
		}
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int c = s.charAt(0) - 'a';
			list[c].add(s);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			int c = s.charAt(0) - 'a';
			ArrayList<String> temp = list[c];
			for (String string : temp) {
				if(check(string, s)) {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

	private static boolean check(String string, String compare) {
		int len = compare.length();
		for (int i = 0; i < len; i++) {
			if (string.charAt(i) != compare.charAt(i))
				return false;
		}
		return true;
	}
	
}

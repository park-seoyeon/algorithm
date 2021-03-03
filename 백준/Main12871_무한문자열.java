package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main12871_무한문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int sLen = s.length();
		int tLen = t.length();
		int lcm = (sLen*tLen)/gcd(sLen, tLen);
		int answer = 0;
		
		if (sLen == tLen) {
			if(s.equals(t))
				answer = 1;
		}
		else {
			StringBuilder fs = new StringBuilder();
			StringBuilder ft = new StringBuilder();
			for (int i = 0; i < lcm/sLen; i++) {
				fs.append(s);
			}
			for (int i = 0; i < lcm/tLen; i++) {
				ft.append(t);
			}
			
			if(fs.toString().equals(ft.toString()))
				answer = 1;
		}
		
		System.out.println(answer);
	}

	private static int gcd(int a, int b) {
		if(a%b == 0) {
			return b;
		}
		return gcd(b, a%b);
	}
	
}

package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4299_태혁이의사랑은타이밍 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int pepero = time(11, 11, 11);
			st = new StringTokenizer(br.readLine());
			int day = stoi(st.nextToken());
			int hour = stoi(st.nextToken());
			int minute = stoi(st.nextToken());
			int nday = time(day, hour, minute);
			int answer = pepero > nday ? -1 : nday - pepero;
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static int time(int day, int hour, int minute) {
		int dtom = day*24*60;
		int htom = hour*60;
		return dtom + htom + minute;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

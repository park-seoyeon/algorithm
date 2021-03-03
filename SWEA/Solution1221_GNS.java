package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1221_GNS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append(" ");
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String s = st.nextToken();
				switch (s) {
				case "ZRO":
					arr[i] = 0;
					break;
				case "ONE":
					arr[i] = 1;
					break;
				case "TWO":
					arr[i] = 2;
					break;
				case "THR":
					arr[i] = 3;
					break;
				case "FOR":
					arr[i] = 4;
					break;
				case "FIV":
					arr[i] = 5;
					break;
				case "SIX":
					arr[i] = 6;
					break;
				case "SVN":
					arr[i] = 7;
					break;
				case "EGT":
					arr[i] = 8;
					break;
				case "NIN":
					arr[i] = 9;
					break;
				}
			}
			
			Arrays.sort(arr);
			
			for (int i = 0; i < N; i++) {
				switch (arr[i]) {
				case 0:
					sb.append("ZRO ");
					break;
				case 1:
					sb.append("ONE ");
					break;
				case 2:
					sb.append("TWO ");
					break;
				case 3:
					sb.append("THR ");
					break;
				case 4:
					sb.append("FOR ");
					break;
				case 5:
					sb.append("FIV ");
					break;
				case 6:
					sb.append("SIX ");
					break;
				case 7:
					sb.append("SVN ");
					break;
				case 8:
					sb.append("EGT ");
					break;
				case 9:
					sb.append("NIN ");
					break;
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
}

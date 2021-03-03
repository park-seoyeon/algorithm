import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5515_2016년요일맞추기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int day = d;
			
			for (int i = 0; i < m-1; i++) {
				day += month[i];
			}
			
			day = (day+3)%7;
			System.out.println("#" + tc + " " + day);
		}
	}
	
}

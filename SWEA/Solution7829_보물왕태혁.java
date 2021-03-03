import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7829_보물왕태혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(br.readLine());
			int max = 0;
			int min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < P; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num > max) {
					max = num;
				}
				
				if (num < min) {
					min = num;
				}
			}
			
			int answer = max*min;
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
	}
	
}

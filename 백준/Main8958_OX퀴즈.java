import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			int len = s.length();
			int arr[] = new int[len];
			int answer = 0;
			int score = 0;
			
			for (int i = 0; i < len; i++) {
				if (s.charAt(i) == 'O') {
					score += 1;
					answer += score;
				}
				else {
					score = 0;
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
	
}

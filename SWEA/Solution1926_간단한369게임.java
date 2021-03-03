package week01;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution1926_간단한369게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			if (i%10 == 3 || i%10 == 6 || i%10 == 9) {
				sb.append("-");
				if (((i/10)%10) == 3 || (i/10)%10 == 6 || (i/10)%10 == 9) {
					sb.append("-");
					if (((i/100)%10) == 3 || (i/100)%10 == 6 || (i/100)%10 == 9) {
						sb.append("-");
					}
				}
			}
			else if ((i/10)%10 == 3 || (i/10)%10 == 6 || (i/10)%10 == 9) {
				sb.append("-");
				if (((i/100)%10) == 3 || (i/100)%10 == 6 || (i/100)%10 == 9) {
					sb.append("-");
				}
			}
			else if (((i/100)%10) == 3 || (i/100)%10 == 6 || (i/100)%10 == 9) {
				sb.append("-");
			}
			else {				
				sb.append(i);
			}
			sb.append(" ");
		}
		
		System.out.println(sb);
	}
	
}

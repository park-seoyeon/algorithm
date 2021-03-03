package week01;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2007_패턴마디의길이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = br.readLine();
			int answer = 1;
			for (int i = 10; i > 1; i--) {
				if(s.substring(0, i-1).equals(s.substring(i, i+i-1))) {
					answer = i;
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		
	}
	
}

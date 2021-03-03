import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9997_미니멀리즘시계 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int angle = Integer.parseInt(br.readLine());
			int temp = angle*2;
			int h = temp/60;
			int m = temp%60;
			
			sb.append("#").append(test_case).append(" ").append(h).append(" ").append(m).append("\n");
		}
		System.out.print(sb);
	}
	
}

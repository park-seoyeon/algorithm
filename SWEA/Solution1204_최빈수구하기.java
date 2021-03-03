package week01;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1204_최빈수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = Integer.parseInt(br.readLine());
			int score[] = new int[101];
			int max = 0;
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int num = Integer.parseInt(st.nextToken());
				score[num]++;
			}
			
			for (int j = 0; j < 101; j++) {
				if (score[j] >= max) {
					max = score[j];
					answer = j;
				}
			}
			
			sb.append("#").append(test).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
}

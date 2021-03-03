package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1476_날짜계산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 1;
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while (true) {
			if ((answer - E) % 15 == 0 && (answer - S) % 28 == 0 && (answer - M) % 19 == 0) {
				break;
			}
			answer++;
		}
		
		System.out.println(answer);
		
	}
	
}

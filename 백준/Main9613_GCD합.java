package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9613_GCD합 {
	static int n, num[], input[];
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			num = new int[n];
			input = new int[2];
			for (int j = 0; j < n; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			comb(0,0);
			System.out.println(answer);
			
		}
	}
	
	private static void comb(int start, int cnt) {
		if (cnt == 2) {
			answer += gcd(input[1], input[0]);
			return;
		}
		
		for (int i = start; i < n; i++) {
			input[cnt] = num[i];
			comb(i+1, cnt+1);
		}
	}
	
	private static int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		}
		
		return gcd(b, a%b);
	}

}

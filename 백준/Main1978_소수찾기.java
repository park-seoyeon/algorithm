package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1978_소수찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (prime(num))
				answer++;
		}
		
		System.out.println(answer);
	}
	
	private static boolean prime(int num) {
		if (num < 2)
			return false;
		else {
			for (int i = 2; i < num; i++) {
				if (num % i == 0)
					return false;
			}
		}
		return true;
	}

}

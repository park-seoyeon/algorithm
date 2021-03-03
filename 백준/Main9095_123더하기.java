package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9095_123더하기 {
	
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			answer = 0;
			int num = Integer.parseInt(br.readLine());
			add(0,num);
			System.out.println(answer);
		}
	}

	private static void add(int sum, int num) {
		if (sum>num) return;
		else if (sum == num) {
			answer++;
			return;
		}
		else {
			for (int i = 1; i <= 3; i++) {
				add(sum+i, num);
			}
		}
	}
}

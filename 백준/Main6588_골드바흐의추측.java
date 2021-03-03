package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main6588_골드바흐의추측 {
	static boolean prime[] = new boolean[1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Arrays.fill(prime, true);
		prime();
		while(s != null) {
			int n = Integer.parseInt(s);
			if (n == 0)
				break;
			
			boolean flag = false;
			for (int i = 2; i <= n/2; i++) {
				if (prime[i] && prime[n-i] && i%2 != 0) {	
					System.out.println(n + " = " + i + " + " + (n-i));
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.println("Goldbach's conjecture is wrong.");
			
			s = br.readLine();
			
		}
	}
	
	private static void prime() {
		prime[1] = false;
		for (int i = 2; i <= 1000000; i++) {
			for (int j = i * 2; j <= 1000000; j+=i) {
				if (!prime[j])
					continue;
				prime[j] = false;			
			}
		}
	}

}
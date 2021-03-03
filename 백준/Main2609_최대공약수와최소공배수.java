package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number[] = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		number[0] = Integer.parseInt(st.nextToken());
		number[1] = Integer.parseInt(st.nextToken());
		
		int a = number[0];
		int b = number[1];
		int gcd = gcd(a,b);
		int lcm = a*b/gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	private static int gcd(int a, int b) {
		if (a % b == 0)
			return b;
		return gcd(b, a%b);
	}
	
}

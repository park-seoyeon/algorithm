package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182_부분수열의합 {

	static int N, S, number[], answer;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		number = new int[N];
		answer = 0;
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, 0);
		
		System.out.println(answer);
	}
	
	private static void perm(int cnt, int sum) {
		if (cnt == N) return;
		if (sum + number[cnt] == S) answer++;
		
		perm(cnt+1, sum);
		perm(cnt+1, sum + number[cnt]);
	}
}

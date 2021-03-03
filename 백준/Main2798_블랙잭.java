import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2798_블랙잭 {

	private static int N;
	private static int M;
	private static int[] number;
	private static int answer;
	private static int[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		answer = 0;
		input = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		System.out.println(answer);
	}

	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			int temp = 0;
			for (int i = 0; i < 3; i++) {
				temp += input[i];
			}
			
			if (temp <= M) {
				answer = Math.max(temp, answer);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			input[cnt] = number[i];
			comb(cnt+1, i+1);
		}
	}
	
}

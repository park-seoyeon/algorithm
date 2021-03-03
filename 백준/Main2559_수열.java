import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int degree[] = new int[N];
		int answer = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			degree[i] = Integer.parseInt(st.nextToken());
		}
		
		int temp = 0;
		for (int i = 0; i <= N-K; i++) {			
			for (int j = i; j < i+K; j++) {
				temp += degree[j];
			}
			answer = Math.max(answer, temp);
			temp = 0;
		}
		
		System.out.println(answer);
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1681_해밀턴순환회로 {
	
	static int N, W[][], max, start;
	static boolean check[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		check = new boolean[N];
		max = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			start = i;
			dfs(i, i, 0, 0);
		}
		
		System.out.println(max);
	}
	private static void dfs(int a, int b, int cnt, int sum) {
		if(cnt==N && start == b) {
			if (sum < max) {
				max = sum;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (check[i]) continue;
			if (W[b][i] == 0) continue;
			if (sum + W[b][i] > max) continue;
			check[i] = true;
			dfs(b, i, cnt+1, sum+W[b][i]);
			check[i] = false;
		}
		
	}

}

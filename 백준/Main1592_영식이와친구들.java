import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1592_영식이와친구들 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int [N+1];
		int cur = 1;
		int cnt = 0;
		
ex:		while(true) {			
			cur = (cur+L)%N;
			if (cur == 0)
				cur = N;
			arr[cur]++;
			for (int i = 1; i <= N; i++) {
				if (arr[i] == M) {
					break ex;
				}
			}
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
}

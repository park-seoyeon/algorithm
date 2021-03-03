import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Jungol2577_회전초밥고 {

	static int N, d, k, c, sushi[], visited[];
	static Deque<Integer> dq = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		visited = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(circle());

	}

	private static int circle() {
		int cnt = 0;
		int max = 0;
		
		for (int i = 0; i < k; i++) {
			dq.addLast(sushi[i]);
			if (visited[sushi[i]] == 0)
				cnt++;
			visited[sushi[i]]++;
		}
		
		if (visited[c] == 0) 
			max = cnt+1;
		else
			max = cnt;
		
		for (int i = 0; i < N-1; i++) {
			int tmp = dq.pollFirst();
			if (visited[tmp] == 1) {
				cnt--;
			}
			visited[tmp]--;
			
			dq.addLast(sushi[(i+k) % N]);
			
			if (visited[sushi[(i+k) % N]] == 0) {
				cnt++;
			}
			visited[sushi[(i+k) % N]]++;
			if (visited[c] == 0)
				max = Math.max(cnt+1, max);
			else
				max = Math.max(max, cnt);
			
		}
		
		return max;
	}

}

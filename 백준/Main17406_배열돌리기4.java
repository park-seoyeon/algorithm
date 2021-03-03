import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main17406_배열돌리기4 {

	static int N, M, K, map[][], number[], answer;
	static List<int[]> list = new ArrayList<int[]>();
	static boolean isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		isSelected = new boolean[K];
		number = new int[K];
		answer = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new int[] {r, c, s});
		}
		
		perm(0);
		System.out.println(answer);
	}
	
	private static void perm(int cnt) {
		if(cnt == K) {
			int temp[][] = new int[N+1][M+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M ; j++) {
					temp[i][j] = map[i][j];
				}
			}
			for (int k = 0; k < K; k++) {				
				int r = list.get(number[k])[0];
				int c = list.get(number[k])[1];
				int s = list.get(number[k])[2];
				circle(r,c,s,temp);
			}
			int min = rowSum(temp);
			answer = Math.min(answer, min);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (isSelected[i] == true) continue;
			number[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
			
		}
	}
	
	private static void circle(int r, int c, int s, int map[][]) {
		int temp = map[r - s][c - s];
	    for(int i = r - s; i < r + s; i++)
	        map[i][c-s] = map[i+1][c-s];
	    for(int j = c - s; j < c + s; j++)
	        map[r + s][j] = map[r + s][j + 1];
	    for(int i = r + s; i > r - s; i--)
	        map[i][c+s] = map[i-1][c+s];
	    for(int j = c + s; j > c - s+1; j--)
	        map[r - s][j] = map[r - s][j - 1];
	    map[r-s][c-s+1] = temp;
	    if (s-1 > 0) {
			circle(r, c, s-1, map);
		}
	}

	private static int rowSum(int map[][]) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum += map[i][j];
			}
			min = Math.min(min, sum);
			sum = 0;
		}
		
		return min;
	}
	
}

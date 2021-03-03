package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15658_연산자끼워넣기2 {
	static int N, number[], oper[], min, max;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		oper = new int[4];
		number = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 0, 0, 1, number[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(int plus, int minus, int multi, int div, int cnt, int cal) {
		
		if (cnt == N) {
			max = Math.max(max, cal);
			min = Math.min(min, cal);
			return;
		}
		
		if(plus < oper[0])
			dfs(plus+1, minus, multi, div, cnt+1, cal + number[cnt]);
		if(minus < oper[1])
			dfs(plus, minus+1, multi, div, cnt+1, cal - number[cnt]);
		if(multi < oper[2])
			dfs(plus, minus, multi+1, div, cnt+1, cal * number[cnt]);
		if(div < oper[3])
			dfs(plus, minus, multi, div+1, cnt+1, cal / number[cnt]);
	}

}

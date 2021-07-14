package new_week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1351_무한수열 {

	private static int P;
	private static int Q;
	private static HashMap<Long, Long> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		map = new HashMap<Long, Long>();
		
		System.out.println(solve(N));
	}

	private static long solve(long n) {
		if(n == 0) 
			return 1;
		if(map.containsKey(n))
			return map.get(n);
		
		long a = (long)Math.floor(n/P);
		long b = (long)Math.floor(n/Q);
		
		map.put(n, solve(a)+solve(b));
		return map.get(n);
	}
}

package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501_퇴사 {

	static int N, T[], P[], max;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		T = new int[16];
		P = new int[16];
		max = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		profit(0, 0);
		System.out.println(max);
	}
	
	private static void profit(int day, int pro) {
		if (day >= N) {
			max = Math.max(max, pro);
			return;
		}
		
		if (day + T[day] <= N)
			profit(day + T[day], pro + P[day]);
		
		profit(day+1, pro);
	}
	
}

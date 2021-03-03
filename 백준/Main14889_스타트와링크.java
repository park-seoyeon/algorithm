import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889_스타트와링크 {

	static int N, R, answer, startLink[][];
	static boolean number[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		R = N/2;
		answer = Integer.MAX_VALUE;
		startLink = new int[N][N];
		number = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				startLink[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0,0);
		System.out.println(answer);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int cal = calc(number);
			answer = Math.min(answer, cal);
			return;
		}
		
		for (int i = start; i < N; i++) {
			number[i] = true;
			comb(cnt+1, i+1);
			number[i] = false;
		}
	}

	private static int calc(boolean[] number) {
		int a = 0;
		int b = 0;
		int cal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if (i == j) continue;
				else if (number[i] && number[j]) {
					a += startLink[i][j];
				}
				else if (!number[i] && !number[j]) {
					b += startLink[i][j];
				}
			}
		}
		
		cal = Math.abs(a-b);
		return cal;
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution5644_무선충전 {

	private static int M;
	private static int A;
	private static int[] amove;
	private static int[] bmove;
	private static int[] dx = {0, -1, 0, 1, 0};
	private static int[] dy = {0, 0, 1, 0, -1};
	private static ArrayList<AP> aplist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = stoi(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = stoi(st.nextToken());
			A = stoi(st.nextToken());
			amove = new int[M];
			bmove = new int[M];
			aplist = new ArrayList<AP>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				amove[i] = stoi(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				bmove[i] = stoi(st.nextToken());
			}
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int y = stoi(st.nextToken());
				int x = stoi(st.nextToken());
				int c = stoi(st.nextToken());
				int p = stoi(st.nextToken());
				
				aplist.add(new AP(x,y,c,p));
			}
			
			System.out.println("#" + tc + " " + move());
		}
	}
	
	private static int move() {
		int x1 = 1;
		int y1 = 1;
		int x2 = 10;
		int y2 = 10;
		
		int sum = max(x1, y1, x2, y2);
		
		for (int i = 0; i < M; i++) {
			x1 += dx[amove[i]];
			y1 += dy[amove[i]];
			x2 += dx[bmove[i]];
			y2 += dy[bmove[i]];
			sum += max(x1, y1, x2, y2);
		}
		return sum;
	}

	private static int max(int x1, int y1, int x2, int y2) {
		int[][] amount = new int[2][A];
		
		for (int i = 0; i < A; i++) {
			amount[0][i] = check(x1,y1,i);
		}
		
		for (int i = 0; i < A; i++) {
			amount[1][i] = check(x2,y2,i);
		}
		
		int max = 0;
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = amount[0][i] + amount[1][j];
				
				if (i == j 
						&& amount[0][i] == amount[1][j])
					sum /= 2;
				max = Math.max(max, sum);
				
			}
		}
		return max;
	}

	private static int check(int x, int y, int ap) {
		int a = Math.abs(x-aplist.get(ap).x);
		int b = Math.abs(y-aplist.get(ap).y);
		int dist = a + b;
		
		if (dist <= aplist.get(ap).c)
			return aplist.get(ap).p;
		else
			return 0;
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
	static class AP {
		int x;
		int y;
		int c;
		int p;
		public AP(int x, int y, int c, int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}

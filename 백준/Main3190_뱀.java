package week05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main3190_뱀 {

	private static int N;
	private static int K;
	private static int[][] map;
	private static int L;
	private static int[][] dir;
	private static int[] dr = { 0, 1, 0, -1 };
	private static int[] dc = { 1, 0, -1, 0 };
	private static Deque<Pos> dq = new ArrayDeque<Pos>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < K; i++) { // 사과 위치 선정
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 2;
		}

		L = Integer.parseInt(br.readLine());
		dir = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i][0] = Integer.parseInt(st.nextToken());
			char temp = st.nextToken().charAt(0);
			dir[i][1] = (temp == 'L') ? 3 : 1;
		}

		System.out.println(solution());

	}

	private static int solution() {
		int s = 0;
		int snakeD = 0;
		int timeidx = 0;
		map[0][0] = 1;
		dq.add(new Pos(0, 0));

		while (true) {
			if (timeidx < L && dir[timeidx][0] == s) {
				snakeD = (snakeD + dir[timeidx][1]) % 4;					
				timeidx++;
			}

			int nr = dq.getFirst().r + dr[snakeD];
			int nc = dq.getFirst().c + dc[snakeD];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				s += 1;
				break;				
			}
			if (map[nr][nc] == 1) { // 자기자신한테 닿았을 때
				s += 1;
				break;
			}
			if (map[nr][nc] == 2) { // 사과 먹었을 때
				map[nr][nc] = 1;
				dq.addFirst(new Pos(nr, nc));
			}
			if (map[nr][nc] == 0){ // 빈공간
				map[nr][nc] = 1;
				dq.addFirst(new Pos(nr, nc));
				
				Pos tail = dq.removeLast();
				map[tail.r][tail.c] = 0;
			}
			
			s++;
		}

		return s;
	}

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}

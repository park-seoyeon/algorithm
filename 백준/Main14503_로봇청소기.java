package week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main14503_로봇청소기 {

	private static int N, M, R, C, Dir, map[][], answer;
	private static int dr[] = { -1, 0, 1, 0 };
	private static int dc[] = { 0, 1, 0, -1 };
	private static Stack<Robot> stack = new Stack<Robot>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;
		Robot robot = new Robot(R, C, Dir);
		stack.push(robot);

		clean();
		
		System.out.println(answer);

	}

	 private static void clean() {
	        int cr, nr, cc, nc, cdir, ndir, moving;

	        while (!stack.isEmpty()) {
	            moving = 0;
	            Robot cur = stack.pop();
	            cr = cur.r;
	            cc = cur.c;
	            cdir = cur.dir;

	            if (map[cr][cc] == 0) {
	                map[cr][cc] = 2;
	                answer++;
	            }

	            for (int k = 0; k < 4; k++) {
	                ndir = (cdir + k) % 4;
	                nr = cr + dr[ndir];
	                nc = cc + dc[ndir];
	                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
	                if (map[nr][nc] == 0) {
	                    stack.push(new Robot(nr, nc, ndir));
	                    moving = 1;
	                }
	            }

	            if (moving == 0)
	            {
	                 ndir = (cdir + 2) % 4;
	                 nr = cr + dr[ndir];
	                 nc = cc + dc[ndir];
	                 if (nr < 0 || nc < 0 || nr >= N || nc >= M)
	                    break;
	                 if (map[nr][nc] == 1)
	                    break;
	                 cur.dir = cdir;
	                 cur.r = nr;
	                 cur.c = nc;
	                 stack.push(new Robot(nr, nc, cdir));
	            }
	        }
	    }


	static class Robot {
		int r;
		int c;
		int dir;

		public Robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}
}

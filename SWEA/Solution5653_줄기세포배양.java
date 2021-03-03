import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5653_줄기세포배양 {

	private static int N;
	private static int M;
	private static int K;
	private static int[][] map;
	private static boolean[][] visited;
	private static int INACTIVE = 2;
	private static int ACTIVE = 1;
	private static int DEATH = 0;
	private static Queue<Cell> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N+K+2][M+K+2];
			visited = new boolean[N+K+2][M+K+2];
			q = new LinkedList<Cell>(); 
			
			int start = K / 2 + 1;
			for (int i = start; i < N + start; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = start; j < M + start; j++) {
					int X = Integer.parseInt(st.nextToken());
					if ( X != 0) {
						map[i][j] = X;
						visited[i][j] = true;
						q.add(new Cell(i, j, X));
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(bfs()).append("\n");
		}
		System.out.print(sb);
	} // end main
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int bfs() {
		while (K-- > 0) {
			for (Cell cell : q) {
				if (cell.status == ACTIVE) {
					for (int i = 0; i < 4; i++) {
						int nr = cell.r + dr[i];
						int nc = cell.c + dc[i];
						if (!visited[nr][nc] && map[nr][nc] < cell.X) {
							map[nr][nc] = cell.X;
						}
					}
				}
			}
			
			int size = q.size();
			for (int t = 0; t < size; t++) {
				Cell cell = q.poll();
				if (cell.status == ACTIVE) {
					for (int i = 0; i < 4; i++) {
						int nr = cell.r + dr[i];
						int nc = cell.c + dc[i];
						if (!visited[nr][nc] && map[nr][nc] < cell.X) {
							q.add(new Cell(nr, nc, map[nr][nc]));
							visited[nr][nc] = true;
						}
					}
				}
				cell.next();
				if (cell.status != DEATH)
					q.add(cell);
			}
		}
		return q.size();
	}

	static class Cell{
		int r, c;
		int X;
		int val;
		int status = INACTIVE;
		public Cell(int r, int c, int X) {
			super();
			this.r = r;
			this.c = c;
			this.X = X;
			this.val = X;
		}
		
		public void next() { // 1시간 지날때마다 호출해주자
            val--; // 현재값 감소
            if (val > 0) return; // 상태는 안바뀜
            if (status == INACTIVE) { // 비활성화 상태
                status = ACTIVE;
                val = X; // 생명력 값으로 다시 셋팅
            } else if (status == ACTIVE) { // 활성화 상태
                status = DEATH;
            }
        }
	}
	
} // end class

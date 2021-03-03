import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7793_오나의여신님 {
	private static int N;
	private static int M;
	private static char[][] map;
	private static LinkedList<Point> q;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N 행, 2 <= R <= 50
		M = Integer.parseInt(st.nextToken()); // M 열, 2 <= R <= 50
		
		q = new LinkedList<Point>();
		Point sPoint = null; // 고슴도치의 위치
//			고슴도치 S, 비버의 굴 D, 돌 X, 물 *, 평범한 지역 . S,D는 유일
		map = new char[N][];
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '*') { // 물 *
					q.offer(new Point(i, j, true)); // 큐에 바로 넣기
				} else if (map[i][j] == 'S') { // 고슴도치 S
					sPoint = new Point(i, j, false); // 큐에 바로 넣기
				}
			}
		}
		q.offer(sPoint); // 고슴도치 넣기
		min = Integer.MAX_VALUE;
		bfs(); // 고슴도치가 물에 빠지면 KAKTUS 출력
		System.out.print(min==Integer.MAX_VALUE?"KAKTUS":min);
	} // end of main
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = { 0, 0,-1, 1};
	public static void bfs() {
		int cnt = 1; // 비버의 굴을 만나는 이동회수
		//큐에 시작좌표 넣기 - 이미 main 에서 넣었음
ex:		while(!q.isEmpty()) {
			int size = q.size(); // 같은 형제들이 개수
			while(--size >= 0) {
				Point point = q.poll();
				int r = point.r;
				int c = point.c;
				boolean isWater = point.isWater;
				for (int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (0 <= nr && nr < N && 0 <= nc && nc < M) { // 배열 범위 내
						if (isWater) { // 물 *
							if (map[nr][nc] == '.' || map[nr][nc] == 'S') { // 평범한지역 or 고슴도치있었던 자리
								map[nr][nc] = '*'; // 방문처리효과
								q.offer(new Point(nr, nc, true));
							}
						} else { // 고습도치 S
							if (map[nr][nc] == 'D') { // 비버의 굴 D
								min = cnt;
								break ex;
							} else if (map[nr][nc] == '.') { // 평범한 지역 .
								map[nr][nc] = 'S';
								q.offer(new Point(nr,nc,false));
							}
						}
					}
				}
			}
			cnt++;
		} // end of while(!q.isEmpty())
	} // end of bfs()
	public static class Point {
		int r;
		int c;
		boolean isWater; // 물인지, 고슴도치인지
		public Point(int r, int c, boolean isWater) {
			this.r = r;
			this.c = c;
			this.isWater = isWater;
		}
	}
}




















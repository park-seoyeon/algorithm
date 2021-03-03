import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236_아기상어 {

	private static int N;
	private static int[][] map;
	private static Shark shark;
	private static Queue<Shark> q;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = { 0, 0,-1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		q = new LinkedList<Shark>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					q.offer(new Shark(i, j));
				}
			}
		}// end input
		
		bfs();
		
	} // end main
	
	private static void bfs() {
		
	}

	public static class Shark {
		int r;
		int c;
		int size;
		int dist = 0;
		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			this.size = 2;
			this.dist = 0;
		}
	} // end Shark
	
} // end class

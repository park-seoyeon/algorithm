import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2206_벽부수고이동하기 {

	static int N, M, map[][], answer;
	static boolean visited[][][];
	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[2][N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		answer = -1;
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0, 0, 0, 1});
		visited[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			
			if (now[0] == N-1 && now[1] == M-1) {
				answer = now[3];
				break;
			}
			for (int k = 0; k < 4; k++) {
				if (now[0]+dx[k] >= 0 && now[0]+dx[k] < N && now[1]+dy[k] >= 0 && now[1]+dy[k] < M
						&&!visited[now[2]][now[0]+dx[k]][now[1]+dy[k]]) {
					if (map[now[0]+dx[k]][now[1]+dy[k]] == 0) {
						visited[now[2]][now[0]+dx[k]][now[1]+dy[k]] = true;
						queue.offer(new int[] {now[0]+dx[k], now[1]+dy[k], now[2], now[3]+1});
					}
					else if(now[2] == 0) {
						visited[1][now[0]+dx[k]][now[1]+dy[k]] = true;
						queue.offer(new int[] {now[0]+dx[k], now[1]+dy[k], 1, now[3]+1});
					}
				}
			}
		}
	}
	
}

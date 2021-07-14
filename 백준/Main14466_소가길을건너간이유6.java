package new_week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14466_소가길을건너간이유6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	static int map[][][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int visit[][];
	static ArrayList<Integer> counts;
	static int cow[][];
	static int N, K, R;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N][2];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (a < c) {
				map[c - 1][d - 1][0] = 1;
			} else if (c < a) {
				map[a - 1][b - 1][0] = 1;
			} else {
				if (b < d) {
					map[c - 1][d - 1][1] = 1;
				} else {
					map[a - 1][b - 1][1] = 1;
				}
			}
//  for(int ii =0;ii<N;ii++) {
//  for(int j=0;j<N;j++) {
//  System.out.print(map[ii][j][0] +" "+ map[ii][j][1]+" ");
//  }
//  System.out.println();
//  }
//  System.out.println();
		}

		cow = new int[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			cow[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		visit = new int[N][N];
		counts = new ArrayList<>();
		Queue<Integer[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
//  for(int[] v: visit) {
//  System.out.println(Arrays.toString(v));
//  }
//  System.out.println();
					answer = 0;
					Integer[] n = new Integer[2];
					n[0] = i;
					n[1] = j;
					q.add(n);
					visit[i][j] = 1;
					while (!q.isEmpty()) {
						n = q.poll();
						if (cow[n[0]][n[1]] == 1) {
							answer++;
						}
						for (int k = 0; k < 4; k++) {
							int nx = n[0] + dx[k];
							int ny = n[1] + dy[k];

							if (nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1 || visit[nx][ny] == 1) {
								continue;
							}

							if (k == 0 && map[nx][ny][1] == 1) {
								continue;
							}
							if (k == 1 && map[nx][ny][0] == 1) {
								continue;
							}
							if (k == 2 && map[n[0]][n[1]][1] == 1) {
								continue;
							}
							if (k == 3 && map[n[0]][n[1]][0] == 1) {
								continue;
							}

							Integer[] m = new Integer[2];
							m[0] = nx;
							m[1] = ny;
							q.add(m);
							visit[nx][ny] = 1;
						}
					}
					counts.add(answer);
				}
			}
		}
		// System.out.println(counts.toString());
		answer = 0;
		for (int i = 0; i < counts.size() - 1; i++) {
			for (int j = i + 1; j < counts.size(); j++) {
				answer += counts.get(i) * counts.get(j);
			}
		}
		System.out.println(answer);
	}
}

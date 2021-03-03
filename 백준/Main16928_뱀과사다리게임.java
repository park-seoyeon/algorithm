package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16928_뱀과사다리게임 {

	private static int[] las = new int[101];
	private static int[] dis = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < (N + M); i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			las[x] = y;
		}

		bfs();
		System.out.println(dis[100]);
	}

	private static void bfs() {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(1);
		dis[1] = 0;
		
		while (!qu.isEmpty()) {
			int r = qu.poll();
			for (int i = 1; i <= 6; i++) {
				int nr = r + i;
				
				if (nr > 100)
					continue;
				
				if (las[nr] != 0) {
					nr = las[nr];
				}
				
				if (dis[nr] == 0) {
					dis[nr] = dis[r] + 1;
					qu.offer(nr);
				}
			}
		}
	}
}

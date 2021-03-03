package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main17140_이차원배열과연산 {

	private static int r;
	private static int c;
	private static int k;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = stoi(st.nextToken())-1;
		c = stoi(st.nextToken())-1;
		k = stoi(st.nextToken());
		map = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		int time = run();
		System.out.println(time);
	}

	private static int run() {
		int time = 0;
		int[] cnt;
		ArrayList<Sort> list;
		while (true) {
			if (time > 100) {
				time = -1;
				break;
			}

			int row = map.length;
			int col = map[0].length;

			if (r < row && c < col) {
				if (map[r][c] == k)
					break;
			}

			int[][] temp = new int[101][101];

			if (row >= col) {
				int max = Integer.MIN_VALUE;

				for (int i = 0; i < row; i++) {
					cnt = new int[101];
					for (int j = 0; j < col; j++) {
						if (map[i][j] == 0)
							continue;
						cnt[map[i][j]]++;
					}

					list = new ArrayList<Sort>();

					for (int j = 1; j < 101; j++) {
						if (cnt[j] != 0) {
							list.add(new Sort(j, cnt[j]));
						}
					}

					Collections.sort(list);

					int z = 0;
					for (int j = 0; j < list.size(); j++) {
						temp[i][z] = list.get(j).n;
						temp[i][z + 1] = list.get(j).len;
						z += 2;
					}
					if (max < list.size() * 2)
						max = list.size() * 2;
				}
				if (max > 100)
					max = 100;
				map = new int[row][max];

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						map[i][j] = temp[i][j];
					}
				}
			} else {
				int max = Integer.MIN_VALUE;

				for (int i = 0; i < col; i++) {
					cnt = new int[101];
					for (int j = 0; j < row; j++) {
						if (map[j][i] == 0)
							continue;
						cnt[map[j][i]]++;
					}

					list = new ArrayList<Sort>();

					for (int j = 1; j < 101; j++) {
						if (cnt[j] != 0) {
							list.add(new Sort(j, cnt[j]));
						}
					}

					Collections.sort(list);

					int z = 0;
					for (int j = 0; j < list.size(); j++) {
						temp[z][i] = list.get(j).n;
						temp[z + 1][i] = list.get(j).len;
						z += 2;
					}
					if (max < list.size() * 2)
						max = list.size() * 2;
				}
				if (max > 100)
					max = 100;
				map = new int[max][col];

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						map[i][j] = temp[i][j];
					}
				}
			}
			time++;
		}
		return time;
	}

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}

	static class Sort implements Comparable<Sort> {
		int n;
		int len;

		public Sort(int n, int len) {
			this.n = n;
			this.len = len;
		}

		@Override
		public int compareTo(Sort o) {
			if (this.len == o.len) {
				return this.n < o.n ? -1 : 1;
			}
			return this.len < o.len ? -1 : 1;
		}

	}
}

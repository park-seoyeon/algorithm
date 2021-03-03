package hwalgo1103_서울_9반_박서연;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = stoi(st.nextToken());
		int C = stoi(st.nextToken());
		int N = stoi(br.readLine());
		int answer = 0;
		ArrayList<Point> list = new ArrayList<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = stoi(st.nextToken());
			int dis = stoi(st.nextToken());
			list.add(new Point(dir, dis, C, R));
		}
		
		st = new StringTokenizer(br.readLine());
		int d = stoi(st.nextToken());
		int v = stoi(st.nextToken());
		
		Point caps = new Point(d, v, C, R);
		int temp = 0;
		
		if (d == 1)
			temp = 2;
		else if (d == 2)
			temp = 1;
		else if (d == 3)
			temp = 4;
		else
			temp = 3;
		
		for (Point point : list) {
			if (point.dir == temp) {
				if (point.dir == 1 || point.dir == 2) {
					answer += Math.min(caps.y + point.y + caps.x + point.x, 
							caps.y + point.y + R - caps.x + R - point.x);
				}
				else {
					answer += Math.min(C - caps.y + C - point.y + caps.x + point.x,
							caps.y + point.y + caps.x + point.x);
				}
			}
			else {
				answer += Math.abs(caps.y - point.y) + Math.abs(caps.x - point.x);
			}
		}
		
		System.out.println(answer);
		
	}

	private static int stoi(String nextToken) {
		return Integer.parseInt(nextToken);
	}
	
	static class Point {
		int dir;
		int y;
		int x;
		public Point(int dir, int dis, int c, int r) {
			this.dir = dir;
			if (dir == 1) {
				this.y = 0;
				this.x = dis;
			}
			else if (dir == 2) {
				this.y = c;
				this.x = dis;
			}
			else if (dir == 3) {
				this.y = dis;
				this.x = 0;
			}
			else {
				this.y = dis;
				this.x = r;
			}
		}
		
	}
}

package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main3005_크로스워드퍼즐쳐다보기 {

	private static ArrayList<String> list;
	private static char[][] arr;
	private static boolean[][] visited;
	private static int R;
	private static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[R][C];
		list = new ArrayList<String>();
		
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] != '#' && !visited[i][j]) {
					visited[i][j] = true;
					find(i, j);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}

	private static void find(int r, int c) {
		StringBuilder sb = new StringBuilder();
		if(r-1 >= 0 && !visited[r-1][c]) {
			for (int i = r; i < R; i++) {
				if(arr[i][c] == '#')
					break;
				sb.append(arr[i][c]);					
			}
			if(sb.length() > 1) {				
				list.add(sb.toString());
			}
			sb = new StringBuilder();
		}
		else if (r == 0) {
			for (int i = r; i < R; i++) {
				if(arr[i][c] == '#')
					break;
				sb.append(arr[i][c]);					
			}
			if(sb.length() > 1) {				
				list.add(sb.toString());
			}
			sb = new StringBuilder();
		}
		if(c-1 >= 0 && !visited[r][c-1]) {
			for (int i = c; i < C; i++) {
				if(arr[r][i] == '#')
					break;
				sb.append(arr[r][i]);					
			}
			if(sb.length() > 1) {				
				list.add(sb.toString());
			}
			sb = new StringBuilder();
		}
		else if (c == 0) {
			for (int i = c; i < C; i++) {
				if(arr[r][i] == '#')
					break;
				sb.append(arr[r][i]);					
			}
			if(sb.length() > 1) {				
				list.add(sb.toString());
			}
			sb = new StringBuilder();
		}
	}
	
}

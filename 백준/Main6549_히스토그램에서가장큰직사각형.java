package day210112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main6549_히스토그램에서가장큰직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] h = new int[n];
			long area = 0;
			Stack<Integer> s = new Stack<Integer>();
			
			if (n == 0)
				break;
			
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				while (!s.isEmpty() && h[s.peek()] > h[i]) {
					long height = h[s.peek()];
					s.pop();
					long width = i;
					
					if (!s.isEmpty()) {
						width = i - s.peek() - 1;
					}
					if (width*height > area) {
						area = width*height;
					}
				}
				s.push(i);
			}
			
			while (!s.isEmpty()) {
				long height = h[s.peek()];
				s.pop();
				long width = n;
				if (!s.isEmpty()) {
					width = n - s.peek() - 1;
				}
				if (width*height > area) {
					area = width*height;
				}
			}
			
			System.out.println(area);
			
		}
	}
	
}

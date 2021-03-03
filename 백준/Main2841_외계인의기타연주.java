package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2841_외계인의기타연주 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer>[] stack = new Stack[7];
		for (int i = 0; i < 7; i++) {
			stack[i] = new Stack<Integer>();
		}
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int jul = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(stack[jul].isEmpty() || stack[jul].peek() < p) {
				answer++;
				stack[jul].add(p);
			}
			else if (stack[jul].peek() > p) {
				while (!stack[jul].isEmpty() && stack[jul].peek() > p) {
					stack[jul].pop();
					answer++;
				}
				if(stack[jul].isEmpty() || stack[jul].peek() < p) {
					answer++;
					stack[jul].add(p);
				}
				else
					continue;
			}
			else
				continue;
		}
		System.out.println(answer);
	}
	
}

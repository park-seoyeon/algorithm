package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1234_비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<Character>();
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char arr[] = st.nextToken().toCharArray();
			
			stack.add(arr[0]);
			for (int i = 1; i < N; i++) {
				if(!stack.isEmpty() && stack.peek() == arr[i]) {
					stack.pop();
				}
				else {
					stack.add(arr[i]);
				}
			}
			
			int size = stack.size();
			for (int i = 0; i < size; i++) {
				sb.append(stack.get(i));
			}
			
			System.out.println("#" + tc + " " + sb.toString());
		}
	}
	
}

package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();
		String S = br.readLine();
		int len = S.length();
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		
		for (int i = 0; i < len; i++) {
			if (S.charAt(i) == '-') {
				if(!op.isEmpty() && op.peek() == '+') {
					op.pop();
					int temp = num.pop() + Integer.parseInt(sb.toString());
					num.add(temp);
				}
				else if (!op.isEmpty() && op.peek() == '-') {
					num.add(Integer.parseInt(sb.toString()));
				}
				else if (op.isEmpty()) {
					num.add(Integer.parseInt(sb.toString()));
				}
				sb = new StringBuilder();
				op.add('-');
			}
			else if (S.charAt(i) == '+') {
				if(!op.isEmpty() && op.peek() == '+') {
					op.pop();
					int temp = num.pop() + Integer.parseInt(sb.toString());
					num.add(temp);
				}
				else if (!op.isEmpty() && op.peek() == '-') {
					num.add(Integer.parseInt(sb.toString()));
				}
				else if (op.isEmpty()) {
					num.add(Integer.parseInt(sb.toString()));
				}
				sb = new StringBuilder();
				op.add('+');
			}
			else {
				sb.append(S.charAt(i));
			}
		}
		
		if(!op.isEmpty() && op.peek() == '+') {
			op.pop();
			int temp = num.pop() + Integer.parseInt(sb.toString());
			num.add(temp);
		}
		else if (!op.isEmpty() && op.peek() == '-') {
			num.add(Integer.parseInt(sb.toString()));
		}
		else if (op.isEmpty()) {
			num.add(Integer.parseInt(sb.toString()));
		}
		
		int arr[] = new int [num.size()];
		
		for (int i = arr.length-1; i >= 0; i--) {
			arr[i] = num.pop();
		}
		
		answer = arr[0];
		if(arr.length > 1) {
			for (int i = 1; i < arr.length; i++) {
				answer = answer - arr[i];
			}
		}
		
		System.out.println(answer);
	}
}

package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16637_괄호추가하기 {

	private static int len;
	private static char[] op;
	private static int[] num;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		String exp = br.readLine();
		if (N == 1) {
			System.out.println(exp);
			return;
		}

		len = N / 2;
		op = new char[len];
		num = new int[len + 1];
		int oi = 0;
		int ni = 0;

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				num[ni++] = exp.charAt(i) - '0';
			else
				op[oi++] = exp.charAt(i);
		}

		answer = Integer.MIN_VALUE;
		dfs(0, num[0]);
		dfs(1, cal(num[0], num[1], op[0]));
		System.out.println(answer);
	}

	private static int cal(int i, int j, char c) {
		int ans;
		if (c == '+') {
			ans = i + j;
		} else if (c == '-') {
			ans = i - j;
		} else {
			ans = i * j;
		}
		return ans;
	}

	private static void dfs(int idx, int value) {
		if (idx == len) {
			answer = value > answer ? value : answer;
			return;
		}

		dfs(idx + 1, cal(value, num[idx + 1], op[idx]));
		if (idx + 2 < len + 1)
			dfs(idx + 2, cal(value, cal(num[idx + 1], num[idx + 2], op[idx + 1]), op[idx]));

	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}

}

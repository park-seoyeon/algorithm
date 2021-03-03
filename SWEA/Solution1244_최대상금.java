package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1244_최대상금 {

	private static int n;
	private static int[] arr;
	private static int result;
	private static int len;
	private static String str;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			n = Integer.parseInt(st.nextToken());
			len = s.length();
			arr = new int[len];

			for (int i = 0; i < len; i++) {
				arr[i] = s.charAt(i) - '0';
			}
			
			while(n > len) {
				n = n-2;
			}
			result = 0;
			dfs(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void dfs(int k, int cnt) {
		int t;
		if (cnt == n) {
			str = "";
			Arrays.stream(arr).forEach(x -> str += String.valueOf(x));
			result = Math.max(result, Integer.parseInt(str));
			return;
		}

		for (int i = k; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				t = arr[i]; arr[i] = arr[j]; arr[j] = t;
				dfs(i, cnt + 1);
				t = arr[i]; arr[i] = arr[j]; arr[j] = t;
			}
		}
	}

}

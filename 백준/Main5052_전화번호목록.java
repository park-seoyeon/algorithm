package day210111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5052_전화번호목록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr);
			
			for (int i = 1; i < N; i++) {
				if (arr[i].startsWith(arr[i-1])) {
					flag = true;
					break;
				}
			}
			
			String answer = flag ? "NO" : "YES";
			System.out.println(answer);
		}
	}
	
}

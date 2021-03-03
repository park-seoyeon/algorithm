package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1946_신입사원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = stoi(br.readLine());
			int[] arr = new int[N+1];
			int answer = 1;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = stoi(st.nextToken());
				arr[idx] = stoi(st.nextToken());
			}
			
			int interview = arr[1];
			
			for (int i = 2; i <= N; i++) {
				if (arr[i] < interview) {
					interview = arr[i];
					answer++;
				}
			}
			System.out.println(answer);
		}
	}

	private static int stoi(String readLine) {
		return Integer.parseInt(readLine);
	}
	
}

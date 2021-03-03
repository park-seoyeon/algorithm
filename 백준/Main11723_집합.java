package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11723_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(in.readLine());
		boolean S[] = new boolean[21];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String s = st.nextToken();
			int x = 0;
			switch (s) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				S[x] = true;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				S[x] = false;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if (S[x])
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if (S[x])
					S[x] = false;
				else
					S[x] = true;
				break;
			case "all":
				Arrays.fill(S, true);
				break;
			case "empty":
				Arrays.fill(S, false);
				break;
			}
		}
		
		System.out.println(sb);
	}
	
}

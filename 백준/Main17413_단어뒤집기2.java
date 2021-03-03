import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		int cnt = 0;
		
		while (cnt < len) {
			if (cnt < len && s.charAt(cnt) == '<') {
				while (cnt < len && s.charAt(cnt) != '>') {
					answer.append(s.charAt(cnt));
					cnt++;
				}
				answer.append(s.charAt(cnt));
				cnt++;
			}
			else if(cnt < len && s.charAt(cnt) == ' ') {
				answer.append(s.charAt(cnt));
				cnt++;
			}
			else {
				while (cnt < len && s.charAt(cnt) != ' ' && s.charAt(cnt) != '<') {
					sb.append(s.charAt(cnt));
					cnt++;
				}
				answer.append(sb.reverse().toString());
				sb = new StringBuilder();
			}
		}
		
		System.out.print(answer);
	}
	
}

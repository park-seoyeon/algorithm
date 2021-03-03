import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		int N = S.length();
		int R;
		int C = 0;

		for(C = 1; C*C < N; C++);
		if(C*C > N) C--;
		while(N%C != 0) C--;
		R = N/C;
		
		char map[][] = new char[R][C];
		int index = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = S.charAt(index);
				index++;
			}
		}
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				sb.append(map[j][i]);
			}
		}
		System.out.println(sb);
	}

}

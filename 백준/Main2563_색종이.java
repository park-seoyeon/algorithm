import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int map[][] = new int[101][101];
		int n = Integer.parseInt(br.readLine());
		int place[][] = new int[n][2];
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			place[i][0] = Integer.parseInt(st.nextToken());
			place[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int k = 0; k < n; k++) {
			int px = place[k][0];
			int py = place[k][1];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[px+i][py+j] != 1) {						
						map[px+i][py+j] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
}

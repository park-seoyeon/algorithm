import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014_활주로건설 {

	private static int N;
	private static int X;
	private static int[][] map;
	private static int answer;
	private static int[][] rev;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			rev = new int[N][N];
			answer = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					rev[j][i] = map[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				if (con(map, i)) {
					answer++;
				}
				if (con(rev, i)) {
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static boolean con(int[][] map, int index) {
		int cnt = 1; // 같은 높이의 길의 개수
		int h = map[index][0];//앞의 칸
		
		for (int i = 1; i < N; i++) {
			if (h == map[index][i]) { // 앞의 칸과 높이가 같다면  cnt 늘려줌
				cnt++;
			}else if(map[index][i] - h == 1) { // 다음 칸이 앞의 칸보다 1칸 높다면
				if(cnt < X) // cnt가 X보다 작으면 놓을 수 없음
					return false;
				else { // 앞의 칸의 값을 바꾸고 cnt 1로 바꿈
					cnt = 1;
					h = map[index][i];
				}
			}else if (h - map[index][i] == 1) { // 다음칸이 앞의 칸보다 1칸 낮다면
				if (N < (X + i)) // 전체 배열 크기보다 건설해야하는 칸이 작으면 놓을 수 없음
					return false;
				for (int j = 1; j < X; j++) { // 크기만큼 단차 1이 유지되는지 탐색
					if (h - map[index][++i] != 1)
						return false;
				}
				h = map[index][i]; // 앞의 칸의 값을 바꾸고
				cnt = 0; // cnt 0으로 초기화
			}else { // 단차가 0이거나 1이 아니면 거짓
				return false;
			}
		}
		return true;
	}
	
}

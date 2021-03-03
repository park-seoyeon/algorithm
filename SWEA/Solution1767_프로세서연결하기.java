import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1767_프로세서연결하기 {

	private static int N;
	private static int[][] maxi;
	private static int max;
	private static int min;
	private static int total;
	private static ArrayList<int[]> list;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			maxi = new int[N][N];
			list = new ArrayList<int[]>(); // 처리해야할 가장 자리 아닌 코어들
			max = 0;
			min = Integer.MAX_VALUE;
			total = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					maxi[i][j] = Integer.parseInt(st.nextToken());
					if ((i == 0 || j == 0 || i == N-1 || j == N-1) && maxi[i][j] == 1) continue;
					//가장자리에 있지 않는 고어 리스트에 추가
					if (maxi[i][j] == 1) {
						list.add(new int[] {i, j});
						total++;
					}
				}
			}// end input
			
			go(0, 0, 0);
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}// end TC
		System.out.println(sb);
	}// end main
	
	private static void go(int index, int cCnt, int lCnt) { // index : 처리할 코어의 index, cCnt : 직전까지 포함된 코어 수
		
		//현재까지 연결된 코어수 + 앞으로 처리해야할 남은 코어 수 : 기대할 수 있는 최대 코어 수
		//기대할 수 있는 최대 코어수가 임시해보다 작다면
		if (cCnt+total-index < max) return; // 가지치기
		
		if(index == total) {
			if(max < cCnt) {
				max = cCnt;
				min = lCnt;
			} else if (max == cCnt) {
				if (min > lCnt) {
					min = lCnt;
				}
			}
			return;
		}
		
		int [] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		// 해당 코어 선택
			//4장향에 직선으로 전으로 전선 놓아보는 시도
		for (int d = 0; d < 4; d++) {
			//해당 방향으로 전선 놓는게 가능한지 체크
			if (isAvailable(r, c, d)) {				
				//가능하다면 전선 놓기 : 맥시노트 판에 2로 셋팅
				int len = setStatus(r, c, d, 2);
				//다음 코어로 넘어가기
				go(index+1, cCnt+1, lCnt + len);
				//놓았던 전선 되돌리기 : 맥시노스 판에 0으로 셋팅
				setStatus(r, c, d, 0);
			}
		}
		// 해당 코어 비선택
		// 아무런 전선도 놓지 않는다.
		go(index+1, cCnt, lCnt);
	}
	
	// 현코어의 위치에서 해당 방향으로 전선을 노는게 가능한지 체크
	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) break; // 가장자리까지 다 전선을 놓을 수 있는 상황
			if(maxi[nr][nc] >= 1) return false; // 1: 코어, 2: 전선
		}
		return true;
	}
	
	// 현코어의 위치에서 해당 방향으로 전선을 놓거나(s=2) 지우는(s=0) 셋팅
	private static int setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c, cnt = 0;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;
			maxi[nr][nc] = s;
			++cnt;
		}
		return cnt;
	}
	
}

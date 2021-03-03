import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1733_오목 {

	static int map[][], answer;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[20][20];
		visited = new boolean[20][20];
		answer = 0;
		int x = 0;
		int y = 0;

		for (int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if (i > 15 && j > 15)
					break;
				else if (map[i][j] == 1) {
					if(omok(i, j, 1)) {
						answer = 1;
						x = i;
						y = j;
						break;
					}
				} else if (map[i][j] == 2) {
					if(omok(i, j, 2)) {
						answer = 2;
						x = i;
						y = j;
						break;
					}
				}
			}
		}

		System.out.println(answer);
		if (x != 0 && y != 0) {
			System.out.println(x + " " + y);
		}
	}

	private static boolean omok(int x, int y, int num) {
		int cnt = 1;
		if (x-1 >= 0 && map[x-1][y] != num) {			
			for (int i = x + 1; i < 20; i++) {
				if (map[i][y] != num)
					break;
				cnt++;
			}
		}

		if (cnt == 5) {
			return true;
		}
		
		cnt = 1;
		if (y-1 >= 0 && map[x][y-1] != num) {			
			for (int j = y + 1; j < 20; j++) {
				if (map[x][j] != num)
					break;
				cnt++;
			}
		}

		if (cnt == 5) {
			return true;
		}
		
		cnt = 1;
		if (x-1 >= 0 && y-1 >= 0 && map[x-1][y-1] != num) {			
			for (int i = x + 1, j = y + 1; i < 20 && j < 20; i++, j++) {
				if (map[i][j] != num)
					break;
				cnt++;
			}
		}

		if (cnt == 5) {
			return true;
		}
		
		cnt = 1;
		if (x+1 < 20 && y-1 >= 0 && map[x+1][y-1] != num) {			
			for (int i = x - 1, j = y + 1; i > 0 && j < 20; i--, j++) {
				if (map[i][j] != num)
					break;
				cnt++;
			}
		}

		if (cnt == 5) {
			return true;
		}

		return false;
	}

}

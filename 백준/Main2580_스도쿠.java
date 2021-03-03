package week04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2580_스도쿠 {

	private static int[][] sudoku;
	private static boolean flag;
	private static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) {
					list.add(new int[] { i, j });
				}
			}
		}

		dfs(0, 0);
		
	}

	private static void dfs(int idx, int cnt) {
		if (cnt == list.size()) {
			print();
			flag = true;
			return;
		}

		if (flag)
			return;

		if (idx >= list.size())
			return;

		int r = list.get(idx)[0];
		int c = list.get(idx)[1];

		for (int i = 1; i < 10; i++) {
			if (check(r, c, i)) {
				sudoku[r][c] = i;
				dfs(idx + 1, cnt + 1);
				sudoku[r][c] = 0;
			}
		}
	}

	private static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	private static boolean check(int r, int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[r][i] == n)
				return false;

			if (sudoku[i][c] == n)
				return false;

		}

		int nr = r / 3 * 3;
		int nc = c / 3 * 3;

		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if (sudoku[i][j] == n) {
					return false;
				}
			}
		}

		return true;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2005_파스칼의삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= TC; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int triangle[][] = new int[N][N];
					
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					if (i == j)
						triangle[i][j] = 1;
					else if (j == 0)
						triangle[i][j] = 1;
					else
						triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
				}
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(triangle[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
}

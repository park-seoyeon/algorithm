import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3234_준환이의양팔저울 {

	static int N, weight[], answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			answer = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			perm(0, 0, 0);
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static void perm(int cnt, int left, int right) {
		if (cnt == N) {
			answer++;
			return;
		}
		
		for (int i = cnt; i < N; i++) {
			int temp = weight[cnt];
			weight[cnt] = weight[i];
			weight[i] = temp;
			
			perm(cnt+1, left + weight[cnt], right);
			if (left >= right+weight[cnt]) {
				perm(cnt+1, left, right + weight[cnt]);
			}
			
			temp = weight[cnt];
			weight[cnt] = weight[i];
			weight[i] = temp;
		}
	}

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309_일곱난쟁이 {

	static int person[], num[], answer, ans[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		person = new int[9];
		num = new int[7];
		ans = new int[7];

		for (int i = 0; i < 9; i++) {
			person[i] = Integer.parseInt(br.readLine());
		}

		comb(0, 0);

		Arrays.sort(ans);

		for (int i = 0; i < 7; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			for (int i = 0; i < 7; i++) {
				answer += num[i];
			}
			if (answer == 100) {
				for (int i = 0; i < 7; i++) {
					ans[i] = num[i];
				}
			}
			answer = 0;
			return;
		}

		for (int i = start; i < 9; i++) {
			num[cnt] = person[i];
			comb(cnt + 1, i + 1);
		}
	}

}

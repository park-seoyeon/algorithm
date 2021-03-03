import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3985_롤케이크 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int roll[] = new int[L+1];
		int max = 0;
		int before_max = 0;
		int person = 0;
		int before_person = 0;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (before_max < (end-start)) {
				before_max = end-start;
				before_person = i;
			}
			for (int j = start; j <= end; j++) {
				if (roll[j] == 0) {
					roll[j] = i;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			for (int j = 1; j <= L; j++) {
				if (roll[j] == i) {
					temp++;
				}
			}
			if (temp > max) {
				person = i;
				max = temp;
			}
		}
		
		System.out.println(before_person);
		System.out.println(person);
	}
	
}

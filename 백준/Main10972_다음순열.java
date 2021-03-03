package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10972_다음순열 {
	
	static int input[], N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		if (perm(input)) {
			for (int i = 0; i < N; i++) {
				System.out.print(input[i] + " ");
			}
		}else {
			System.out.println("-1");
		}
	}
	
	private static boolean perm(int[] arr) {
		int a = N-1;
		while(a>0 && arr[a-1] >= arr[a])
			a--;
		if (a <= 0)
			return false;
		
		int b = N-1;
		while (arr[a-1] >= arr[b]) b--;
		
		int tmp = arr[a-1];
		arr[a-1] = arr[b];
		arr[b] = tmp;
		
		int num = N-a;
		int temp[] = new int[num];
		
		int st = a;
		for (int i = 0; i < num; i++) {
			temp[i] = arr[st];
			st++;
		}
		
		Arrays.sort(temp);
		
		int start = 0;
		for (int i = a; i < N; i++) {
			arr[i] = temp[start];
			start++;
		}
		
		return true;
	}
}

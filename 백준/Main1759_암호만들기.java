package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759_암호만들기 {
	
	static int L, C;
	static String alpha[], temp[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new String[C];
		temp = new String[L];
		
		st = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken();
		}
		
		Arrays.sort(alpha);
		
		comb(0,0);
		
	}

	private static void comb(int cnt, int start) {
		int ja = 0;
		int mo = 0;
		if (cnt == L) {
			for (int j = 0; j < L; j++) {
				if(temp[j].equals("a") || temp[j].equals("e") || temp[j].equals("i") || temp[j].equals("o") || temp[j].equals("u"))
					mo++;
			}
			ja = L - mo;
			
			if (mo >= 1 && ja >= 2) {
				for (int i = 0; i < L; i++) {
					System.out.print(temp[i]);
				}
				System.out.println();
			}
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			temp[cnt] = alpha[i];
			comb(cnt+1, i+1);
		}
	}
}

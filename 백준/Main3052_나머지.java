import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3052_나머지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean num[] =  new boolean[42];
		int cnt = 0;
		
		for (int i = 0; i < 10; i++) {
			int tmp = Integer.parseInt(br.readLine());
			num[tmp%42] = true;
		}
		
		for (int i = 0; i < 42; i++) {
			if(num[i])
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
}

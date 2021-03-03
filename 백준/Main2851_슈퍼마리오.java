import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2851_슈퍼마리오 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mushroom[] = new int[10];
		int answer = 0;
		
		for (int i = 0; i < 10; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < 10; i++) {
			answer += mushroom[i];
			if (answer == 100)
				break;
			
			else if(answer > 100) {
				int a = answer - 100;
				int b = 100 - (answer - mushroom[i]);
				if (a > b) {
					answer = answer - mushroom[i];
				}
				break;
			}
		}
		
		System.out.println(answer);
	}
	
}

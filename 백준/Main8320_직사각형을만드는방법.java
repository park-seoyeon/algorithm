import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main8320_직사각형을만드는방법 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rec = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = i; i*j <= n; j++) {
				rec++;
			}
		}
		
		System.out.println(rec);
	}
	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(br.readLine());
		ArrayList<Integer> garo = new ArrayList<Integer>();
		ArrayList<Integer> sero = new ArrayList<Integer>();
		garo.add(0);
		sero.add(0);
		int ansX = 0;
		int ansY = 0;
		
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("1")) {
				garo.add(Integer.parseInt(st.nextToken()));
			}
			else {
				sero.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Collections.sort(garo);
		Collections.sort(sero);
		garo.add(x);
		sero.add(y);
		
		int len = garo.size();
		for (int i = 0; i < len-1; i++) {
			int temp = garo.get(i+1) - garo.get(i);
			ansX = Math.max(ansX, temp);
		}
		
		len = sero.size();
		for (int i = 0; i < len-1; i++) {
			int temp = sero.get(i+1) - sero.get(i);
			ansY = Math.max(ansY, temp);
		}
		
		System.out.println(ansX*ansY);
	}
	
}

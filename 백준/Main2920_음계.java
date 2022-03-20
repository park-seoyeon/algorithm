package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2920_음계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[8];
		boolean flag = true;
		
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(arr[0] == 1) {
			for (int i = 0; i < 4; i++) {
				if(arr[i] == i + 1 && arr[i] + arr[7 - i] == 9)
					continue;
				else {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "ascending" : "mixed");
		}
		else if(arr[0] == 8) {
			for (int i = 0; i < 4; i++) {
				if(arr[i] == 8 - i && arr[i] + arr[7 - i] == 9)
					continue;
				else {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "descending" : "mixed");
		}
		else {
			System.out.println("mixed");
		}
	}
	
}

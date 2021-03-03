package day210112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4344_평균은넘겠지_소은코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;

		// 각 줄 arr배열에 입력받기
		String[] arr = new String[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), "\n");
			arr[i] = st.nextToken();
		}

		// 각 줄 계산하기
		for (int j = 0; j < num; j++) {
			double sum = 0;
			int count = 0;
			String[] arr2 = arr[j].split(" ");

			int[] arr3 = new int[arr2.length];
			for (int i = 0; i < arr2.length; i++) {
				arr3[i] = Integer.parseInt(arr2[i]);
			}

			for (int i = 1; i < arr3.length; i++) {
				sum += arr3[i];
			}
			double avg = sum / arr3[0];
			for (int i = 1; i < arr3.length; i++) {
				if (arr3[i] > avg) {
					count++;
				}
			}

			float a = (float) count / arr3[0] * 100;
			System.out.printf("%.3f", a);
			System.out.println("%");
		}
		br.close();

	}

}

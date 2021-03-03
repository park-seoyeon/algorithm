package algo_d3;

import java.util.Scanner;
public class Solution10200_구독자전쟁 {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int N = 3;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int max = 0;
			int min = 0;
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			if (arr[0] > (arr[1]+arr[2])) {
				min = 0;
				if (arr[1] < arr[2]) {
					max = arr[1];
				}
				else
					max = arr[2];
			}
			else {
				min = (arr[1] + arr[2]) - arr[0];
                if(arr[1] >= arr[2]){
                    max = arr[2];
                }
                else{
                    max = arr[1];
                }
			}
			System.out.println("#" + test_case + " " + max + " " + min);
		}
	}

}

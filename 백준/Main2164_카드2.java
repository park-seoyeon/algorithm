package new_week03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		Queue<Integer> qu = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			qu.add(i);
		}
		
		while (qu.size() > 1) {
			qu.poll();
			if (qu.size() == 1) {
				break;
			}
			else {
				int temp = qu.poll();
				qu.add(temp);
			}
		}
		
		answer = qu.poll();
		
		System.out.println(answer);
	}
}

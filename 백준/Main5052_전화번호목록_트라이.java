package day210111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5052_전화번호목록_트라이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
myfor:		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			Node root = new Node(false, 'a', new Node[10]);
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				int len = s.length();
				Node cur = root;
				for (int j = 0; j < len; j++) {
					char temp = s.charAt(j);
					boolean isEnd = j == len-1 ? true : false;
					int index = temp - '0';
					if (cur.childs[index] == null) {
						cur.childs[index] = new Node(isEnd, temp, new Node[10]);
						cur = cur.childs[index];
					}
					else {
						if (cur.childs[index].isEnd) {
							System.out.println("NO");
							continue myfor;
						}
						else {
							cur = cur.childs[index];
						}
					}
					if (isEnd) {
						for (Node node : cur.childs) {
							if (node != null) {
								System.out.println("NO");
								continue myfor;
							}
						}
					}
				}
			}
			System.out.println("YES");
		}
	}
	
	static class Node{
		boolean isEnd;
		char c;
		Node[] childs;
		public Node(boolean isEnd, char c, Node[] childs) {
			this.isEnd = isEnd;
			this.c = c;
			this.childs = childs;
		}
	}
}

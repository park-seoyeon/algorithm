package week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1231_중위순회 {

	private static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			CompleteBinaryTree tree = new CompleteBinaryTree(N);
			
			for(int i=0; i<N; ++i){
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree.add(st.nextToken());
			}
			
			sb.append("#").append(test_case).append(" ");
			tree.printTreeByInOrder(1);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static class CompleteBinaryTree{
		private String[] nodes;
		private int lastIndex;
		private final int SIZE;
		
		public CompleteBinaryTree(int size){
			SIZE = size;
			nodes = new String[size+1];// 0인덱스 사용 안함
		}
		
		public void add(String e){
			nodes[++lastIndex] = e;
		}
		
		private void printTreeByInOrder(int current){
			if(current <= lastIndex){
				printTreeByInOrder(current*2);			// 왼쪽 자식노드 방문처리
				sb.append(nodes[current]);		// 현재 노드 방문처리
				printTreeByInOrder(current*2+1);			// 오른쪽 자식노드 방문처리
			}
		}
	}
}

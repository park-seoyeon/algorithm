package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1707_이분그래프 {
	
	static int V, E, answer, visited[];
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			answer = 0;
			
			adjList = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			
			visited = new int[V+1];
			for(int i=0; i<E; ++i) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
				adjList[to].add(from);
			}
			
			for(int i = 1; i <= V; i++)
	        {
	            if(visited[i] == 0)
	            {
	                bfs(i);    
	            }
	        }
			
			if (answer == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	private static void bfs(int cur) {
		Queue<Integer>  queue = new LinkedList<Integer>();
		
		queue.offer(cur);
		visited[cur] = 1;
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			
			for(int temp : adjList[a]) {
				if(visited[temp] == visited[a]) {
					answer = 1;
					return;
				}
				if (visited[temp] == 0) {
					visited[temp] = visited[a]*-1;
					queue.offer(temp);
				}
			}
		}
	}
}

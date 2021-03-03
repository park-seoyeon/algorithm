package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11724_연결요소의개수 {

	static int N, M, answer;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		adjList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		visited = new boolean[N+1];
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	private static void dfs(int cur) {
		visited[cur] = true;
		
		for(int temp : adjList[cur]) {
			if(!visited[temp]) {
				dfs(temp);
			}
		}
	}
	
}

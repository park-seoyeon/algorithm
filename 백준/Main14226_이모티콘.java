package week02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main14226_이모티콘 {

	static int S;
	static boolean visited[][] = new boolean[20000][20000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		
		bfs();
	}
	
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {1,0,0});
		visited[1][0] = true;
		
		while (!queue.isEmpty()) {
			int display = queue.peek()[0];
			int clip = queue.peek()[1];
			int time = queue.peek()[2];
			queue.poll();
			if (display == S) {
				System.out.println(time);
				break;
			}
			if (!visited[display][display]) {
				visited[display][display] = true;
				queue.offer(new int[] {display,display,time+1});
			}
			if (clip != 0 && !visited[display+clip][clip]) {
				visited[display+clip][clip] = true;
				queue.offer(new int[] {display + clip,clip,time+1});
			}
			if (display-1 >= 0 && !visited[display-1][clip]) {
				visited[display-1][clip] = true;
				queue.offer(new int[] {display - 1,clip,time+1});
			}
		}
	}
}

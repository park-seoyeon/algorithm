package week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13549_숨바꼭질3 {
	static int N, K, arr[], answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[200001];
		Arrays.fill(arr, 100000000);
		arr[N] = 0;
		bfs();
		System.out.println(answer);
		
	}
	
	private static void bfs() {
        int next = N; // 수빈이 위치
        int move[] = new int[2]; // 이동방식
        Queue<Integer> qu = new LinkedList<Integer>();
        qu.offer(next);

        while (!qu.isEmpty() && next != K) {
            next = qu.poll();
            int temp = next * 2; // 순간이동
            move[0] = next - 1; // -1 이동
            move[1] = next + 1; // 1 이동
            
            while(temp != 0
            		&& temp <= 200000 
            		&& arr[temp] > arr[next]) {
            	qu.offer(temp);
            	arr[temp] = arr[next]; 
            	temp *= 2;
            }

            for (int i = 0; i < 2; i++) {
                if (move[i] >=0 && move[i] <= 150000) {
                	if (arr[move[i]] > arr[next]+1) { // 1이나 -1 이동할 때
                		qu.offer(move[i]);
                		arr[move[i]] = arr[next]+1; // 이동하면서 arr에 1초 더해서 넣기 
                	}
                }
            }
        }
        answer = arr[K]; // arr에 K까지 오는데 걸린시간
    }
}

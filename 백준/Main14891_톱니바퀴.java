package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14891_톱니바퀴 {

	private static int K;
    private static int[][] arr;
    private static boolean[] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        arr = new int[4][8];
        visited = new boolean[4];
        int[] point = {1, 2, 4, 8};
        int answer = 0;
        
        for (int i = 0; i < 4; i++) {
        	String s = br.readLine();
        	for (int j = 0; j < 8; j++) {
        		arr[i][j] = s.charAt(j) - '0';
        	}
        }
        
        K = stoi(br.readLine());
        
        for (int i = 0; i < K; i++) {
        	Arrays.fill(visited, false);
        	st = new StringTokenizer(br.readLine());
        	int mag = stoi(st.nextToken());
        	int rot = stoi(st.nextToken());
        	dfs(mag-1, rot);
        }
        
        for (int i = 0; i < 4; i++) {
        	if(arr[i][0] == 1)
        		answer += point[i];
        }
        
        System.out.println(answer);
    }
 
    private static void dfs(int mag, int rot) {
        visited[mag] = true;
        if(round(mag-1) 
                && !visited[mag-1]
                        && arr[mag][6] != arr[mag-1][2])
            dfs(mag-1, -rot);
         
        if(round(mag+1)
                && !visited[mag+1]
                        && arr[mag][2] != arr[mag+1][6])
            dfs(mag+1, -rot);
         
        rotation(mag, rot);
    }
 
    private static void rotation(int mag, int rot) {
        if (rot == 1) {
            // 0 1 2 3 4 5 6 7
            // 7 0 1 2 3 4 5 6
            int temp = arr[mag][7];
            for (int i = 7; i > 0; i--) {
                arr[mag][i] = arr[mag][i-1];
            }
            arr[mag][0] = temp;
        }
        else if (rot == -1) {
            // 0 1 2 3 4 5 6 7
            // 1 2 3 4 5 6 7 0
            int temp = arr[mag][0];
            for (int i = 0; i < 7; i++) {
                arr[mag][i] = arr[mag][i+1];
            }
            arr[mag][7] = temp;
        }
    }
 
    private static boolean round(int mag) {
        if(mag < 0 || mag > 3)
            return false;
        return true;
    }
 
    private static int stoi(String readLine) {
        return Integer.parseInt(readLine);
    }
	
}

package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main7785_회사에있는사람 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeMap<String, String> tm = new TreeMap<String, String>();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(tm.containsKey(s) && st.nextToken().equals("leave"))
				tm.remove(s);
			else
				tm.put(s, s);
		}
		
		Iterator<String> iter = tm.descendingKeySet().iterator();
		
		String key;
		while (iter.hasNext()) {
			key = iter.next();
			System.out.println(tm.get(key));
		}
	}
	
}

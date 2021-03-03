import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pro_2021kakao_신규아이디추천 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String new_id = br.readLine();

		String answer = solution(new_id);
		System.out.println(answer);

	}

	private static String solution(String new_id) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		ArrayList<Character> id = new ArrayList<Character>();
		int len = new_id.length();
		for (int i = 0; i < len; i++) {
			id.add(new_id.charAt(i));
		}
		
		// 1단계
		for (int i = 0; i < id.size(); i++) {
			if (id.get(i) >= 65 && id.get(i) <= 90) {
				id.set(i, (char) (id.get(i) + 32));
			}
		}

		// 2단계
		for (int i = 0; i < id.size(); i++) {
			if (id.get(i) >= 97 && id.get(i) <= 122) continue;
			else if (id.get(i) >= 48 && id.get(i) <= 57) continue;
			else if (id.get(i) == 45 || id.get(i) == 95 || id.get(i) == 46 ) continue;
			else {
				id.remove(i);
				i--;
			}
		}
		
		// 3단계
		for (int i = 0; i < id.size(); i++) {
			if (id.get(i) == 46) {
				if (i+1 <= id.size()-1 
						&& id.get(i+1) == 46) {
					id.remove(i+1);
					i--;
				}
			}
		}
		
		// 4단계
		if (!id.isEmpty() && id.get(0) == 46) id.remove(0);
		if (!id.isEmpty() && id.get(id.size()-1) == 46) id.remove(id.size()-1);

		// 5단계
		if (id.isEmpty()) id.add('a');
		
		// 6단계
		while (id.size() > 15) {
			id.remove(id.size()-1);
		}
		if (!id.isEmpty() && id.get(id.size()-1) == 46) id.remove(id.size()-1);
		
		// 7단계
		if (id.size() < 3) {
			char tmp = id.get(id.size()-1);
			while (id.size() < 3) {
				id.add(tmp);
			}
		}
		
		for (int i = 0; i < id.size(); i++) {
			sb.append(id.get(i));
		}
		answer = sb.toString();
		return answer;
	}

}

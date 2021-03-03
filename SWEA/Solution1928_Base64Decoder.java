package week01;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Solution1928_Base64Decoder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String text = br.readLine();
			byte target[] = text.getBytes();
			
			Decoder decoder = Base64.getDecoder();
			byte decodeByte[] = decoder.decode(target);
			
			sb.append("#").append(test_case).append(" ").append(new String(decodeByte)).append("\n");
		}
		System.out.println(sb);
	}
	
}

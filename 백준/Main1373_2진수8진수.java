import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1373_2진수8진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String bin = sb.reverse().toString();
        int n = bin.length();

        sb = new StringBuilder();
        for (int i = 0; i < n; i += 3) {
            int temp = 0;
            int num = 1;
            for (int j = i; j < i + 3; j++) {
                if (j < n) {
                    temp += (bin.charAt(j) - '0') * num;
                    num *= 2;
                }
            }
            sb.append(temp);
        }
        System.out.println(sb.reverse().toString());
    }
}
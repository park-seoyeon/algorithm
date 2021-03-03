import java.util.Scanner;

public class Main2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		char cro[] = sc.next().toCharArray();
		int len = cro.length;
		int cnt = 0;
		
		for (int i = 0; i < len; i++) {
			switch (cro[i]) {
			case 'c':
				if (i+1 < len && cro[i+1] == '=') {
					cnt++;
					i++;
					break;
				}
				else if (i+1 < len && cro[i+1] == '-') {
					cnt++;
					i++;
					break;
				}
				else
					cnt++;
				break;
			
			case 'd':
				if (i+1 < len && cro[i+1] == 'z') {
					if (i+2 < len && cro[i+2] == '=') {
						cnt++;
						i += 2;
						break;
					}
					else {
						cnt++;
						break;
					}
				}
				else if (i+1 < len && cro[i+1] == '-') {
					cnt++;
					i++;
					break;
				}
				else
					cnt++;
				break;
			
			case 'l':
				if (i+1 < len && cro[i+1] == 'j') {
					cnt++;
					i++;
					break;
				}
				else
					cnt++;
				break;
			
			case 'n':
				if (i+1 < len && cro[i+1] == 'j') {
					cnt++;
					i++;
					break;
				}
				else
					cnt++;
				break;
			
			case 's':
				if (i+1 < len && cro[i+1] == '=') {
					cnt++;
					i++;
					break;
				}
				else
					cnt++;
				break;
			
			case 'z':
				if (i+1 < len && cro[i+1] == '=') {
					cnt++;
					i++;
					break;
				}
				else
					cnt++;
				break;
			
			default:
				cnt++;
			}
		
		}
		
		System.out.println(cnt);
	}
	
}

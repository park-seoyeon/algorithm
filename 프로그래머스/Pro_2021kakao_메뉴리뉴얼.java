import java.util.*;

public class Pro_2021kakao_메뉴리뉴얼 {
     Map<String, Integer> map;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
//        String[] answer = solution(orders, course);
        
//        System.out.println(Arrays.toString(answer));
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<String> temp = new ArrayList<>();
        int olen = orders.length;
        int clen = course.length;
        
        for (int i = 0; i < clen; i++) {
            map = new HashMap<>();
            for (int j = 0; j < olen; j++) {
                char[] arr = orders[j].toCharArray();
                Arrays.sort(arr);
                String result = new String(arr);
                comb(0, 0, course[i], result, "");
            }
            List<String> list = new ArrayList<>(map.keySet());
            
            list.sort((o1, o2)->map.get(o2) - map.get(o1));
            
            if (!list.isEmpty()) {    
                int num = map.get(list.get(0));
                if(num > 1) {                
                    temp.add(list.get(0));
                    int size = list.size();
                    
                    for (int k = 1; k < size; k++) {
                        if(map.get(list.get(k)) < num)
                            break;
                        temp.add(list.get(k));
                    }
                }
            }
        }
       
        Collections.sort(temp);
        
        int n = temp.size();
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }

    private void comb(int cnt, int start, int R, String order, String string) {
        if(cnt == R) {
            if(map.containsKey(string)) {
                int num = map.get(string);
                map.put(string, num + 1);
            }
            else {
                map.put(string, 1);
            }
            string = "";
            return;
        }
        
        for (int i = start; i < order.length(); i++) {
            comb(cnt+1, i+1, R, order, string + order.charAt(i));
        }
    }
    
}
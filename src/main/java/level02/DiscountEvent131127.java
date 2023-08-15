package level02;

import java.util.HashMap;
import java.util.Map;

/**
 * 할인 행사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class DiscountEvent131127 {

    /*
    입출력 예
    want	number	discount	result
    ["banana", "apple", "rice", "pork", "pot"]	[3, 2, 2, 2, 1]	["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]	3
    ["apple"]	[10]	["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]	0
     */
    public static void main(String[] args) {
        System.out.println(new DiscountEvent131127().solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        ));
        System.out.println(new DiscountEvent131127().solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}
        ));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0 ; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for(int date = 0; date < discount.length; date++) {
            if(date >= 10) {
                String outOfRangeProduct = discount[date - 10];
                if(wantMap.containsKey(outOfRangeProduct)) {
                    wantMap.put(outOfRangeProduct, wantMap.get(outOfRangeProduct) + 1);
                }
            }


            if(wantMap.containsKey(discount[date])) {
                wantMap.put(discount[date], wantMap.get(discount[date]) - 1);
            }

            int restCount = 0;
            for(int wantNum : wantMap.values()) {
                if(wantNum > 0) {
                    restCount++;
                }
            }
            if(restCount == 0) {
                answer++;
            }

        }
        return answer;
    }
}

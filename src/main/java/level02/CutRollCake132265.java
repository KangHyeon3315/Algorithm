package level02;

import java.util.HashMap;
import java.util.Map;

/**
 * 롤케이크 자르기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/132265
 */
public class CutRollCake132265 {

    /*
    입출력 예
    topping	result
    [1, 2, 1, 3, 1, 4, 1, 2]	2
    [1, 2, 3, 1, 4]	0
     */
    public static void main(String[] args) {
        CutRollCake132265 cutRollCake = new CutRollCake132265();
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(cutRollCake.solution(topping));

        topping = new int[] {1, 2, 3, 1, 4};
        System.out.println(cutRollCake.solution(topping));
    }

    public int solution(int[] topping) {
        Map<Integer, Integer> aMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();
        for(int t : topping) bMap.put(t, bMap.getOrDefault(t, 0) + 1);

        int answer = 0;
        for(int t : topping) {
            bMap.put(t, bMap.get(t) - 1);
            if(bMap.get(t) == 0) bMap.remove(t);
            aMap.put(t, aMap.getOrDefault(t, 0) + 1);

            if(aMap.keySet().size() == bMap.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}

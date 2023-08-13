package level02;

import java.util.HashSet;
import java.util.Set;

/**
 * 연속 부분 수열 합의 개수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 */
public class ContiguousSubsequenceSum131701 {

    /*
    입출력 예
    elements	result
    [7,9,1,1,4]	18
     */
    public static void main(String[] args) {
        System.out.println(new ContiguousSubsequenceSum131701().solution(new int[]{7, 9, 1, 1, 4}));
    }

    public int solution(int[] elements) {
        Set<Integer> valueSet = new HashSet<>();
        for(int i = 0; i < elements.length; i++) {
            int sum = 0;
            for(int j = 0; j < elements.length; j++) {
                sum += elements[(i + j) % elements.length];

                valueSet.add(sum);
            }
        }

        return valueSet.size();
    }
}

package level01;

import java.util.Arrays;

/**
 * 예산
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12982
 */
public class Budget12982 {

    /*
    입출력 예
    d	budget	result
    [1,3,2,5,4]	9	3
    [2,2,3,3]	10	4
     */
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;

        int result = solution(d, budget);
        System.out.println(result);

        d = new int[]{2,2,3,3};
        budget = 10;
        result = solution(d, budget);
        System.out.println(result);
    }

    public static int solution(int[] d, int budget) {
        Arrays.sort(d);

        int total = 0;
        int answer = 0;
        for(int i : d) {
            if(total + i > budget) break;

            total += i;
            answer++;
        }
        return answer;
    }
}

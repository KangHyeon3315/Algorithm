package level03;

import java.util.Arrays;

/**
 * 최고의 집합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12938
 */
public class BestSet12938 {

    /*
    입출력 예
    n	s	result
    2	9	[4, 5]
    2	1	[-1]
    2	8	[4, 4]
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BestSet12938().solution(2, 9)));
        System.out.println(Arrays.toString(new BestSet12938().solution(2, 1)));
        System.out.println(Arrays.toString(new BestSet12938().solution(2, 8)));
    }

    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[]{-1};
        }

        int idx = 0;
        int num = s;
        int[] answer = new int[n];
        for(int i = n; i > 0; i--) {
            answer[idx] = num / i;
            num -= answer[idx];
            idx++;
        }

        Arrays.sort(answer);
        return answer;
    }
}

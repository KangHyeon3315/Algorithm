package level2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 요격 시스템
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/181188
 */
public class InterceptionSystem181188 {

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        int result = solution(targets);
        System.out.println(result);
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]));

        int answer = 0;
        int rangeStart = Integer.MIN_VALUE;
        int rangeEnd = Integer.MAX_VALUE;

        for (int i = 0; i < targets.length; i++) {
            int start = targets[i][0];
            int end = targets[i][1];

            if (rangeEnd <= start) {
                answer++;
                rangeStart = start;
                rangeEnd = end;
            } else {
                rangeStart = Math.max(rangeStart, start);
                rangeEnd = Math.min(rangeEnd, end);
            }
        }
        return answer + 1;
    }
}

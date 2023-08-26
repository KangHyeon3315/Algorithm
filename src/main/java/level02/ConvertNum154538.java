package level02;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 숫자 변환하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */
public class ConvertNum154538 {
    /*
    입출력 예
    x	y	n	result
    10	40	5	2
    10	40	30	1
    2	5	4	-1
     */
    public static void main(String[] args) {
        ConvertNum154538 convertNum = new ConvertNum154538();
        int x = 10;
        int y = 40;
        int n = 5;
        System.out.println(convertNum.solution(x, y, n));

        x = 10;
        y = 40;
        n = 30;
        System.out.println(convertNum.solution(x, y, n));

        x = 2;
        y = 5;
        n = 4;
        System.out.println(convertNum.solution(x, y, n));
    }

    public int solution(int x, int y, int n) {
        if(x == y) return 0;

        int maxSize = 1_000_000;
        int[] dp = new int[maxSize]; // 최소 연산 횟수
        Queue<Integer> calcQ = new ArrayDeque<>();
        calcQ.add(x);
        while(calcQ.size() > 0) {
            int newX = calcQ.poll();

            int nextX = newX + n;
            if(nextX <= maxSize && dp[nextX - 1] == 0) {
                dp[newX + n - 1] = dp[newX - 1] + 1;
                calcQ.add(nextX);
            }

            nextX = newX * 2;
            if(nextX <= maxSize && dp[nextX - 1] == 0) {
                dp[nextX - 1] = dp[newX - 1] + 1;
                calcQ.add(nextX);
            }

            nextX = newX * 3;
            if(nextX <= maxSize &&  dp[nextX - 1] == 0) {
                dp[nextX - 1] = dp[newX - 1] + 1;
                calcQ.add(nextX);
            }
        }

        if(dp[y - 1] == 0) return -1;
        return dp[y - 1];
    }
}

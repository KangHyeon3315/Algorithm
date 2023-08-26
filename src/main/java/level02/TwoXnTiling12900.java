package level02;

/**
 * 2 x n 타일링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12900
 */
public class TwoXnTiling12900 {

    /*
    입출력 예
    n	result
    4	5
     */
    public static void main(String[] args) {
        TwoXnTiling12900 twoXnTiling = new TwoXnTiling12900();
        int n = 4;
        System.out.println(twoXnTiling.solution(n));
    }

    public int solution(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
        }

        return dp[n - 1];
    }
}

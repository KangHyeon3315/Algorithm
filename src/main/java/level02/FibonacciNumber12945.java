package level02;

/**
 * 피보나치 수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class FibonacciNumber12945 {

    /*
    입출력 예
    n	return
    3	2
    5	5
     */
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int fnMinus2 = 0;
        int fnMinus1 = 1;
        int fn = 1;
        for(int i = 2; i <= n; i++) {
            fn = (fnMinus1 + fnMinus2) % 1234567;

            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }

        return fn % 1234567;
    }
}

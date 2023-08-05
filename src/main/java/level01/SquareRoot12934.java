package level01;

/**
 * 정수 제곱근 판별
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12934
 */
public class SquareRoot12934 {

    /*
    입출력 예
    n	return
    121	144
    3	-1
     */
    public static void main(String[] args) {
        long n = 121;
        long result = solution(n);
        System.out.println(result);

        n = 3;
        result = solution(n);
        System.out.println(result);
    }

    public static long solution(long n) {
        double sqrt = Math.sqrt(n);

        if(n % sqrt == 0) {
            return ((long)sqrt + 1) * ((long)sqrt + 1);
        }

        return -1;
    }
}

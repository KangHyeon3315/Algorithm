package level01;

/**
 * 두 정수 사이의 합
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12912
 */
public class SumOfTwoNumBetween12912 {

    /*
    입출력 예
    a	b	return
    3	5	12
    3	3	3
    5	3	12
     */
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        long result = solution(a, b);
        System.out.println(result);

        a = 3;
        b = 3;
        result = solution(a, b);
        System.out.println(result);

        a = 5;
        b = 3;
        result = solution(a, b);
        System.out.println(result);
    }

    public static long solution(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        return (max - min + 1) * ((long) max + min) / 2;
    }
}

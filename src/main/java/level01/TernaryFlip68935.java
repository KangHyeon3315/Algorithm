package level01;

/**
 * 3진법 뒤집기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
public class TernaryFlip68935 {

    /*
    입출력 예
    n	result
    45	7
    125	229
     */
    public static void main(String[] args) {
        int n = 45;
        int result = solution(n);
        System.out.println(result);

        n = 125;
        result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
    }
}

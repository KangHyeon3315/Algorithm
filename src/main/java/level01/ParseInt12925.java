package level01;

/**
 * 문자열을 정수로 바꾸기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12925
 */
public class ParseInt12925 {

    public static void main(String[] args) {
        String s = "1234";
        int result = solution(s);
        System.out.println(result);

        s = "-1234";
        result = solution(s);
        System.out.println(result);
    }

    public static int solution(String s) {
        return Integer.parseInt(s);
    }
}

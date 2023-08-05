package level01;

/**
 * 자릿수 더하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12931
 */
public class SumOfDigit12931 {

    /*
    입출력 예
    N	answer
    123	6
    987	24
     */
    public static void main(String[] args) {
        int n = 123;
        int result = solution(n);
        System.out.println(result);

        n = 987;
        result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int answer = 0;

        char[] digits = (n + "").toCharArray();
        for(int i = 0; i < digits.length; i++) {
            answer += digits[i] - '0';
        }

        return answer;
    }
}

package level02;

/**
 * 다음 큰 숫자
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12911
 */
public class NextBigNumber12911 {

    /*
    입출력 예
    n	result
    78	83
    15	23
     */
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int nCount = Integer.bitCount(n);

        int answer = n + 1;
        while(Integer.bitCount(answer) != nCount) {
            answer++;
        }

        return answer;
    }
}

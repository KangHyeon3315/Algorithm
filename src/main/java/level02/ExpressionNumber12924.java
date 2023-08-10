package level02;

/**
 * 숫자의 표현
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12924
 */
public class ExpressionNumber12924 {

    /*
    입출력 예
    n	result
    15	4
     */
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;

        int min = 0;
        int max = 0;
        int sum = 0;
        while(min <= n) {

            if(sum < n) {
                ++max;
                sum += max;
            } else if(sum > n) {
                ++min;
                sum -= min;
            } else {
                answer++;
                ++min;
                sum -= min;
            }

        }

        return answer;
    }
}

package level01;

/**
 * 약수의 합
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12928
 */
public class SumOfDivisor12928 {

    /*
    입출력 예
    n	return
    12	28
    5	6
     */
    public static void main(String[] args) {
        int n = 12;
        int result = solution(n);
        System.out.println(result);

        n = 5;
        result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i = 1; i * i <= n; i++) {
            if(i * i == n) {
                answer += i;
            } else if(n % i == 0) {
                answer += i;
                answer += n / i;
            }

        }
        return answer;
    }
}

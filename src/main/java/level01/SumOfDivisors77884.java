package level01;

/**
 * 약수의 개수와 덧셈
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 */
public class SumOfDivisors77884 {
    /*
    입출력 예
    left	right	result
    13	17	43
    24	27	52
     */
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int result = solution(left, right);
        System.out.println(result);

        left = 24;
        right = 27;
        result = solution(left, right);
        System.out.println(result);
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            int sqrt = (int)Math.sqrt(i);

            if(sqrt * sqrt == i) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}

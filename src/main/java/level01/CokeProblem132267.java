package level01;

/**
 * 콜라 문제
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/132267
 */
public class CokeProblem132267 {
    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 20;

        int result = solution(a, b, n);
        System.out.println(result);

        a = 3;
        result = solution(a, b, n);
        System.out.println(result);
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        int ownNum = n;
        while(ownNum >= a) {
            int newGiven = (ownNum / a) * b;
            answer += newGiven;
            ownNum = (ownNum % a) + newGiven;

        }

        return answer;
    }
}
